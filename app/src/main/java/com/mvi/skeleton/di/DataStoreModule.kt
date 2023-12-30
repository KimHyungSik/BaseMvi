package com.mvi.skeleton.di

import android.content.Context
import com.example.pref.datastore.DataStoreItem
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Singleton
    @Provides
    fun providerDatStore(
        @ApplicationContext appContext: Context
    ): DataStoreItem = DataStoreItem(appContext, "domain")
}