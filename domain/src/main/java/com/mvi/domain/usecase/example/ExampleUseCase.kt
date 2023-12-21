package com.mvi.domain.usecase.example

import com.mvi.domain.model.example.ExampleDataDto
import com.mvi.domain.repository.ExampleRepository
import kotlinx.coroutines.flow.Flow

interface ExampleUseCase {
    suspend fun getExample(): Flow<ExampleDataDto>
}