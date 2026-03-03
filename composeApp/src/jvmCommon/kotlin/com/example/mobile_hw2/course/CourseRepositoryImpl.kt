package com.example.mobile_hw2.course

import com.example.mobile_hw2.network.NetworkClient

class CourseRepositoryImpl : CourseRepository {
    private val api: CourseApi = NetworkClient.retrofit.create(CourseApi::class.java)

    override suspend fun getCourses(): List<CourseDto> {
        val response = api.getCourses()
        return response.data.courses
    }
}