package com.example.mobile_hw2.course

data class CoursesState(
    val courses: List<CourseDto> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
