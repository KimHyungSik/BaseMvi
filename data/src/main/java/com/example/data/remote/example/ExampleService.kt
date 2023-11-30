package com.example.data.remote.example

import com.example.domain.model.example.DataResponse
import retrofit2.http.GET

interface ExampleService {
    @GET("")
    suspend fun getExample(): DataResponse
}