package com.example.keys.server

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignUpParams(
    val username: String,
    val email: String,
    val password: String

)


//"username": "string",
//"email": "user@example.com",
//"password": "string"