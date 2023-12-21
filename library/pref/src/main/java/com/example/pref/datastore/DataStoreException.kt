package com.example.pref.datastore

class DataStoreException(
    message: String,
    cause: Throwable? = null
) : RuntimeException(message, cause)
