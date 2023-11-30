package com.example.data.repository.example

import com.example.data.remote.example.ExampleService
import com.example.domain.model.example.Data
import com.example.domain.model.example.toDto
import com.example.domain.repository.ExampleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ExampleRepositoryImp @Inject constructor(
    private val api: ExampleService
) : ExampleRepository {
    override suspend fun getExampleData(): Flow<Data> = flow {
        emit(api.getExample().toDto())
    }

}