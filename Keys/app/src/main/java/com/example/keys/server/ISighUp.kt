package com.example.keys.server

import retrofit2.http.Body
import retrofit2.http.POST

interface ISighUp {
    @POST("api/auth/register")
    suspend fun getSignUp(@Body registerParams: SignUpParams)
}