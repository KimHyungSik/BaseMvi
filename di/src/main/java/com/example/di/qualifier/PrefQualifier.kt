package com.example.di.qualifier

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AccountPref

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class GlobalPref
