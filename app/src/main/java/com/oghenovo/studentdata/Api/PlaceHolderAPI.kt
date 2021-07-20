package com.oghenovo.studentdata.Api

import com.oghenovo.studentdata.model.Items
import com.oghenovo.studentdata.model.Student
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PlaceHolderAPI {

    @GET("items")
    suspend fun getItems(): List<Items>

    @POST("students")
    suspend fun addStudents(@Body newSet: Student): List<Student>
}