package com.example.keys.server

import retrofit2.http.Body
import retrofit2.http.POST

interface ILogin {
    @POST("api/auth/login")
    suspend fun getLogin(@Body loginParams: LoginParams): LoginResponse
}