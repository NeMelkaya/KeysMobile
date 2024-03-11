package com.example.keys.server

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header

interface IRole {
    @GET("api/create")
    suspend fun getUser(@Header("Authorization") value: String, @Body userParams: UserParams): UserResponse
}