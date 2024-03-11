package com.example.keys.server

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface IForms {
    @GET("api/myApplications")
    suspend fun getForms(@Header("Authorization") value: String): FormsResponse
}