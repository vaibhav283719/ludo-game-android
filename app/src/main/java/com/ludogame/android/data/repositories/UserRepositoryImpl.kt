package com.ludogame.android.data.repositories

import com.ludogame.android.domain.repositories.UserRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

@Singleton
class UserRepositoryImpl @Inject constructor() : UserRepository {
    override fun observeLeaderboard(): Flow<List<Pair<String, Int>>> =
        flowOf(listOf("Player 1" to 1200, "Player 2" to 1000))
}
