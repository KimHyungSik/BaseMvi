package com.mvi.data.remote.example

import com.mvi.domain.model.example.ExampleResponse
import retrofit2.http.GET

interface ExampleService {
    @GET("api/users/")
    suspend fun getExample(): ExampleResponse
}