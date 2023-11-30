package com.example.domain.usecase.example

import com.example.domain.repository.ExampleRepository

class ExampleUseCase(private val repository: ExampleRepository) {
    suspend fun getExample() = repository.getExampleData()
}