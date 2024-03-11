package com.example.keys.server

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header

interface IUsers {
    @GET("api/create")
    suspend fun getUsers(@Header("Authorization") value: String): UsersResponse
}