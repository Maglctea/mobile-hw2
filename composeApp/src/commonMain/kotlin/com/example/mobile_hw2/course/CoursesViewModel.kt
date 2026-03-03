package com.example.mobile_hw2.course

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import mobilehw2.composeapp.generated.resources.Res
import mobilehw2.composeapp.generated.resources.courses_error_unknown
import org.jetbrains.compose.resources.getString

class CoursesViewModel(
    private val courseRepository: CourseRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(CoursesState())
    val uiState = _uiState.asStateFlow()

    init {
        loadCourses()
    }

    fun loadCourses() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            try {
                val courses = courseRepository.getCourses()
                _uiState.update { it.copy(courses = courses, isLoading = false) }
            } catch (e: Exception) {
                val errorMessage = e.message ?: getString(Res.string.courses_error_unknown)
                _uiState.update { it.copy(error = errorMessage, isLoading = false) }
            }
        }
    }
}