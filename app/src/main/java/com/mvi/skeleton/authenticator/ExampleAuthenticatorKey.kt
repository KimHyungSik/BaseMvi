package com.mvi.skeleton.authenticator

import com.mvi.account.AuthenticatorKey

object ExampleAuthenticatorKey: AuthenticatorKey {
    override val accountType: String
        get() = "example_account"
    override val authTokenType: String
        get() = "example_authToken"

}
