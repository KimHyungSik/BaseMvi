package com.example.di

import android.content.Context
import com.mvi.data.local.AccountPrefManager
import com.mvi.data.local.GlobalPrefManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PrefModule {

    @Provides
    @Singleton
    fun providerGlobalPref(
        @ApplicationContext appContext: Context
    ): GlobalPrefManager = GlobalPrefManager(
        appContext
    )

    @Provides
    @Singleton
    fun providerAccountPref(
        @ApplicationContext appContext: Context
    ): AccountPrefManager = AccountPrefManager(
        appContext
    )
}