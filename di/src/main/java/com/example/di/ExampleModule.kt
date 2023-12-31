package com.example.di

import com.mvi.data.remote.example.ExampleService
import com.mvi.data.repository.example.ExampleRepositoryImp
import com.mvi.data.usecase.ExampleUseCaseImp
import com.mvi.domain.repository.ExampleRepository
import com.mvi.domain.usecase.example.ExampleUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ExampleModule {
    @Provides
    fun providerExampleService(retrofit: Retrofit): ExampleService =
        retrofit.create(ExampleService::class.java)
}

@Module
@InstallIn(SingletonComponent::class)
abstract class ExampleRepositoryModule {

    @Binds
    abstract fun bindExampleRepository(exampleRepository: ExampleRepositoryImp): ExampleRepository

    @Binds
    abstract fun bindExampleUserCase(exampleUseCase: ExampleUseCaseImp): ExampleUseCase
}

