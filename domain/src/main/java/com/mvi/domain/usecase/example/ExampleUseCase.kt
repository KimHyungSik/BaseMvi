package com.mvi.domain.usecase.example

import com.mvi.domain.repository.ExampleRepository

class ExampleUseCase(private val repository: ExampleRepository) {
    suspend fun getExample() = repository.getExampleData()
}