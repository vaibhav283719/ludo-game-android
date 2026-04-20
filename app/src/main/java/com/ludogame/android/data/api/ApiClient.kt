package com.ludogame.android.data.api

import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiClient @Inject constructor(
    val retrofit: Retrofit
)
