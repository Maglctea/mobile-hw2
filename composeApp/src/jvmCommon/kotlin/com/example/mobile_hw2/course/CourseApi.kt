package com.example.mobile_hw2.course

import com.example.mobile_hw2.auth.ApiResponse
import retrofit2.http.GET

interface CourseApi {
    @GET("api/v2.course.list")
    suspend fun getCourses(): ApiResponse<CoursesDto>
}