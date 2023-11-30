package com.example.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.example.ExampleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val exampleUseCase: ExampleUseCase
) : ViewModel() {
    fun init(){
        viewModelScope.launch {
            exampleUseCase.getExample()
                .collect{
                    Log.d("LOGEE", "init: $it")
                }
        }
    }
}