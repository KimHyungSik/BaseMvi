package com.example.mviskeletonapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object ExampleModule {
    @Provides
    @Singleton
    fun provideOkhttpClient(): OkHttpClient = OkHttpClient.Builder().build()

    @Provides
    @Singleton
    fun providerRetrofit(
        okHttpClient: OkHttpClient,
    ): Retrofit = Retrofit.Builder()
            .baseUrl("https://reqres.in/api/users/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient).build()
}