package com.ludogame.android.domain.usecases

import com.ludogame.android.domain.repositories.UserRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class UserUseCases @Inject constructor(
    private val repository: UserRepository
) {
    fun dailyRewardAmount(): Int = 100
    fun leaderboard(): Flow<List<Pair<String, Int>>> = repository.observeLeaderboard()
}
