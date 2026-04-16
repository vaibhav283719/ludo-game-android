package com.ludogame.android.domain.repositories

import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun observeLeaderboard(): Flow<List<Pair<String, Int>>>
}
