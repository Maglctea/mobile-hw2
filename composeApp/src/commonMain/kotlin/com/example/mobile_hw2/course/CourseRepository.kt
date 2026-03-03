package com.example.mobile_hw2.course

interface CourseRepository {
    suspend fun getCourses(): List<CourseDto>
}