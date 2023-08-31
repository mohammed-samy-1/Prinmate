package com.devmo.auth.domain.repository

interface AuthRepository {
    fun login()
    fun signUp()
    fun checkAuth()
}