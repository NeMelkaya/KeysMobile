package com.example.keys.server

import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface IFormCreate {
    @POST("api/create")
    suspend fun getFormCreate(@Header("Authorization") value: String, @Body formCreateParams: FormCreateParams): FormCreateResponse
}