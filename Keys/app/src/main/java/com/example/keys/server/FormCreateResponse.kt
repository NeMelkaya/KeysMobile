package com.example.keys.server

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FormCreateResponse(
    val token: String,
    val expiration: String,
    val user: String
)