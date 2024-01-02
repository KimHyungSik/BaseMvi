package com.example.di

import com.example.di.qualifier.AccountPref
import com.example.di.qualifier.GlobalPref
import com.example.pref.manager.PrefManager
import com.mvi.data.local.AccountPrefManager
import com.mvi.data.local.GlobalPrefManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PrefModule {

    @Binds
    @Singleton
    @GlobalPref
    abstract fun providerGlobalPref(devicePref: GlobalPrefManager): PrefManager

    @Binds
    @Singleton
    @AccountPref
    abstract fun providerAccountPref(accountPref: AccountPrefManager): PrefManager
}