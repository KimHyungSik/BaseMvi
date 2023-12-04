package com.mvi.domain.repository

import com.mvi.domain.model.example.ExampleDataDto
import kotlinx.coroutines.flow.Flow

interface ExampleRepository {
    suspend fun getExampleData(): Flow<ExampleDataDto>
}