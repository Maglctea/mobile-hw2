package com.example.mobile_hw2.course

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import mobilehw2.composeapp.generated.resources.Res
import mobilehw2.composeapp.generated.resources.courses_course_item_text
import mobilehw2.composeapp.generated.resources.courses_empty
import mobilehw2.composeapp.generated.resources.courses_retry
import mobilehw2.composeapp.generated.resources.courses_title
import org.jetbrains.compose.resources.stringResource


@Preview
@Composable
fun CoursesScreen(
    viewModel: CoursesViewModel = viewModel { CoursesViewModel(createCourseRepository()) }
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(Res.string.courses_title),
            color = Color.White,
            fontSize = 28.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        when {
            uiState.isLoading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }

            uiState.error != null -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(uiState.error!!, color = Color.Red)
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(onClick = { viewModel.loadCourses() }) {
                            Text(stringResource(Res.string.courses_retry))
                        }
                    }
                }
            }

            uiState.courses.isEmpty() -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(stringResource(Res.string.courses_empty), color = Color.White)
                }
            }

            else -> {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(uiState.courses) { course ->
                        CourseItem(course)
                    }
                }
            }
        }
    }
}


@Composable
private fun CourseItem(course: CourseDto) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = course.title, fontSize = 16.sp)
            if (course.description.isNotEmpty()) {
                Text(
                    text = course.description,
                    fontSize = 13.sp,
                    modifier = Modifier.padding(top = 4.dp),
                    maxLines = 2
                )
            }
            course.inner?.let { inner ->
                Text(
                    text = "${inner.count_complete_lessons}/${inner.lessons_count} ${
                        stringResource(
                            Res.string.courses_course_item_text
                        )
                    }",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}