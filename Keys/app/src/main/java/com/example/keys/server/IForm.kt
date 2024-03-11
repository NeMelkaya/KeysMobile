package com.example.keys.server

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface IForm {
    @GET("api/application")
    suspend fun getForm(@Header("Authorization") value: String, @Body formParams: FormParams): FormResponse
}