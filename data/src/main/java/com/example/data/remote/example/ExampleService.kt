package com.example.data.remote.example

import com.example.domain.model.example.ExampleResponse
import retrofit2.http.GET

interface ExampleService {
    @GET("api/users/")
    suspend fun getExample(): ExampleResponse
}