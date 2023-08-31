package com.devmo.auth.di

import com.devmo.auth.data.repository.AuthRepositoryImpl
import com.devmo.auth.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {
    @Singleton
    @Provides
    fun authRepository(): AuthRepository {
        return AuthRepositoryImpl()
    }
}