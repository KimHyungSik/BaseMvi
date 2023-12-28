package com.mvi.data.repository.example

import android.util.Log
import com.example.pref.datastore.DataStoreItem
import com.mvi.data.remote.example.ExampleService
import com.mvi.domain.model.example.ExampleDataDto
import com.mvi.data.model.example.toDto
import com.mvi.domain.model.example.SupportDto
import com.mvi.domain.repository.ExampleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class ExampleRepositoryImp @Inject constructor(
    private val dataStoreItem: DataStoreItem,
    private val api: ExampleService
) : ExampleRepository {
    override suspend fun getExampleData(): Flow<ExampleDataDto>{
        Log.d("LOGEE", "ExampleRepositoryImp")
        val exampleResponse = api.getExample()
        Log.d("LOGEE", "getExampleData: $exampleResponse")
        val dto = exampleResponse.toDto()
        Log.d("LOGEE", "getExampleData: $exampleResponse")
        dataStoreItem.put("Key", exampleResponse)
        val getFromDataStore = dataStoreItem.get(
            "Key", ExampleDataDto(
                emptyList(),
                1, 2, SupportDto("text", "url"), 3, 4
            )
        )
        Log.d("LOGEE", "getExampleData: $getFromDataStore")
        return flowOf(dto)
    }
}