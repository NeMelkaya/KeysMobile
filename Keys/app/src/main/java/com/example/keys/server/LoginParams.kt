package com.example.keys.server

import kotlinx.serialization.Serializable

@Serializable
data class LoginParams(
    val email: String,
    val password: String

)