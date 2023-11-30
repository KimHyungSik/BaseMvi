package com.example.mviskeletonapp.di

import com.example.data.remote.example.ExampleService
import com.example.data.repository.example.ExampleRepositoryImp
import com.example.domain.repository.ExampleRepository
import com.example.domain.usecase.example.ExampleUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ExampleModule {
    @Provides
    fun providerExampleService(retrofit: Retrofit): ExampleService =
        retrofit.create(ExampleService::class.java)

    @Provides
    fun providerExampleUseCase(repository: ExampleRepository) = ExampleUseCase(repository)
}

@Module
@InstallIn(SingletonComponent::class)
abstract class ExampleRepositoryModule {

    @Binds
    abstract fun bindExampleRepository(exampleRepository: ExampleRepositoryImp): ExampleRepository
}

