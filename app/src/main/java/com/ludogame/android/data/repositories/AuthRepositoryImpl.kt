package com.ludogame.android.data.repositories

import com.ludogame.android.domain.models.Player
import com.ludogame.android.domain.repositories.AuthRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor() : AuthRepository {
    override suspend fun signInGuest(): Result<Player> =
        Result.success(Player(id = "guest", name = "Guest"))

    override suspend fun signInGoogle(idToken: String): Result<Player> =
        Result.success(Player(id = idToken.take(8), name = "Google User"))
}
