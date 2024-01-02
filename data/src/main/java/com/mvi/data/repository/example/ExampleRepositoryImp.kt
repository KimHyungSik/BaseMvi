package com.mvi.data.repository.example

import com.mvi.data.remote.example.ExampleService
import com.mvi.domain.model.example.ExampleDataDto
import com.mvi.data.model.example.toDto
import com.mvi.domain.repository.ExampleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class ExampleRepositoryImp @Inject constructor(
    private val api: ExampleService
) : ExampleRepository {
    override suspend fun getExampleData(): Flow<ExampleDataDto> {
        val exampleResponse = api.getExample()
        val dto = exampleResponse.toDto()

        return flowOf(dto)
    }
}