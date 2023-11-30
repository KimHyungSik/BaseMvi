package com.example.domain.repository

import com.example.domain.model.example.ExampleDataDto
import kotlinx.coroutines.flow.Flow

interface ExampleRepository {
    suspend fun getExampleData(): Flow<ExampleDataDto>
}