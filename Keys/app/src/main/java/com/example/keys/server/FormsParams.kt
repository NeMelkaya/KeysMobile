package com.example.keys.server

import kotlinx.serialization.Serializable
import java.sql.Date
import java.time.LocalDate


@Serializable
data class FormsParams(
    val id: String,
)