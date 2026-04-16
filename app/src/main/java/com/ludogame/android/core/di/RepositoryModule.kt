package com.ludogame.android.core.di

import com.ludogame.android.data.repositories.AuthRepositoryImpl
import com.ludogame.android.data.repositories.GameRepositoryImpl
import com.ludogame.android.data.repositories.MultiplayerRepositoryImpl
import com.ludogame.android.data.repositories.UserRepositoryImpl
import com.ludogame.android.domain.repositories.AuthRepository
import com.ludogame.android.domain.repositories.GameRepository
import com.ludogame.android.domain.repositories.MultiplayerRepository
import com.ludogame.android.domain.repositories.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindGameRepository(impl: GameRepositoryImpl): GameRepository

    @Binds
    @Singleton
    abstract fun bindAuthRepository(impl: AuthRepositoryImpl): AuthRepository

    @Binds
    @Singleton
    abstract fun bindMultiplayerRepository(impl: MultiplayerRepositoryImpl): MultiplayerRepository

    @Binds
    @Singleton
    abstract fun bindUserRepository(impl: UserRepositoryImpl): UserRepository
}
