package com.mvi.skeleton.di

import android.content.Context
import com.example.pref.PrefItem
import com.example.pref.datastore.DataStoreItem
import com.example.pref.memory.MemoryPrefItem
import com.mvi.skeleton.di.qualifier.DataStorePref
import com.mvi.skeleton.di.qualifier.MemoryPref
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PrefModule {

    @Singleton
    @Provides
    @DataStorePref
    fun providerDatStorePref(
        @ApplicationContext appContext: Context
    ): PrefItem = DataStoreItem(appContext, "domain")

    @Singleton
    @Provides
    @MemoryPref
    fun providerMemoryPref(): PrefItem = MemoryPrefItem()

}