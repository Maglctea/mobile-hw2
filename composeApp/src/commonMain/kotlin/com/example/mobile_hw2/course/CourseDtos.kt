package com.example.mobile_hw2.course

data class CoursesDto(
    val courses: List<CourseDto>
)

data class CourseDto(
    val id: Long,
    val title: String,
    val description: String,
    val type: String,
    val progress_status: String?,
    val is_published: Boolean,
    val updated: String,
    val greeting: String?,
    val companies: List<CourseCompanyDto>,
    val inner: CourseInnerDto?,
    val background_image: BackgroundImageDto?
)

data class CourseCompanyDto(
    val id: Long,
    val name: String
)

data class CourseInnerDto(
    val count_complete_lessons: Int,
    val lessons_count: Int,
    val unit_count: Int,
    val chapters_count: Int
)

data class BackgroundImageDto(
    val id: Long,
    val url: String,
    val name: String,
    val extension: String,
    val width: Int?,
    val height: Int?,
    val size: Int,
    val file_size: Int,
    val source: String,
    val status: String,
    val original_file_name: String,
    val creator_id: Long,
    val creator_first_name: String,
    val creator_last_name: String,
    val base_id: Long?
)
