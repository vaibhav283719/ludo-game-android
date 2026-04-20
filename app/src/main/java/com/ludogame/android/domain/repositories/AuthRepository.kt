package com.ludogame.android.domain.repositories

import com.ludogame.android.domain.models.Player

interface AuthRepository {
    suspend fun signInGuest(): Result<Player>
    suspend fun signInGoogle(idToken: String): Result<Player>
}
