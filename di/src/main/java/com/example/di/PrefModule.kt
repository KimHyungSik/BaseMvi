package com.example.di

import android.content.Context
import com.example.di.qualifier.AccountPref
import com.example.di.qualifier.GlobalPref
import com.example.pref.manager.PrefManager
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
    @GlobalPref
    fun providerGlobalPref(
        @ApplicationContext appContext: Context
    ): PrefManager = PrefManager(
        appContext = appContext,
        domainName = "Global"
    )

    @Provides
    @Singleton
    @AccountPref
    fun providerAccountPref(
        @ApplicationContext appContext: Context
    ): PrefManager = PrefManager(
        appContext = appContext,
        domainName = "Account"
    )
}