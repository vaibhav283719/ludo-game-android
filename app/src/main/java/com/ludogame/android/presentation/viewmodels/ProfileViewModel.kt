package com.ludogame.android.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.ludogame.android.domain.usecases.UserUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val userUseCases: UserUseCases
) : ViewModel() {
    fun getDailyRewardCoins() = userUseCases.dailyRewardAmount()
}
