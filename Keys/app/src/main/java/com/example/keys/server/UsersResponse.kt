package com.example.keys.server

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class UsersResponse(
    val users: List<UserResponse>,
)