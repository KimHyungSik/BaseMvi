package com.mvi.data.repository.example

import android.util.Log
import com.example.pref.datastore.DataStoreItem
import com.mvi.data.remote.example.ExampleService
import com.mvi.domain.model.example.ExampleDataDto
import com.mvi.data.model.example.toDto
import com.mvi.domain.repository.ExampleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ExampleRepositoryImp @Inject constructor(
    private val dataStoreItem: DataStoreItem,
    private val api: ExampleService
) : ExampleRepository {
    override suspend fun getExampleData(): Flow<ExampleDataDto> = flow {
        val exampleResponse = api.getExample().toDto()
        Log.d("LOGEE", "getExampleData: $exampleResponse")
        dataStoreItem.put("Key", exampleResponse)
        emit(exampleResponse)
    }
}