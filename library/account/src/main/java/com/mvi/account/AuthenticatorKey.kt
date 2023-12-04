package com.mvi.account

interface AuthenticatorKey {
    val accountType: String
    val authTokenType: String
}