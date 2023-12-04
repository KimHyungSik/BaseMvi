package com.mvi.data.repository.example

import com.mvi.data.remote.example.ExampleService
import com.mvi.domain.model.example.ExampleDataDto
import com.mvi.domain.model.example.toDto
import com.mvi.domain.repository.ExampleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ExampleRepositoryImp @Inject constructor(
    private val api: ExampleService
) : ExampleRepository {
    override suspend fun getExampleData(): Flow<ExampleDataDto> = flow {
        emit(api.getExample().toDto())
    }
}