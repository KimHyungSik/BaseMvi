package com.example.mviskeletonapp.di

import android.accounts.AccountManager
import android.content.Context
import com.example.account.AccountManagerHelper
import com.example.mviskeletonapp.authenticator.ExampleAuthenticatorKey
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AccountManagerModule {

    @Singleton
    @Provides
    fun providerAccountManager(
        @ApplicationContext appContext: Context
    ): AccountManager = AccountManager.get(appContext)

    @Singleton
    @Provides
    fun providerAccountManagerHelper(
        accountManager: AccountManager
    ): AccountManagerHelper =
        AccountManagerHelper(
            accountManager,
            ExampleAuthenticatorKey,
        )
}