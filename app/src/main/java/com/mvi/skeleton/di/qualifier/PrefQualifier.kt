package com.mvi.skeleton.di.qualifier

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DataStorePref

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MemoryPref
