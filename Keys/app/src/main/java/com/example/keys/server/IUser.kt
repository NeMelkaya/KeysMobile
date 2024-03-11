package com.example.keys.server

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface IUser {
    @GET("user/{id}")
    suspend fun getUser( @Header("Authorization") value: String, @Path("id") id: String): UserResponse
}