package com.example.domain.repository

import com.example.domain.model.example.Data
import kotlinx.coroutines.flow.Flow

interface ExampleRepository {
    suspend fun getExampleData(): Flow<Data>
}