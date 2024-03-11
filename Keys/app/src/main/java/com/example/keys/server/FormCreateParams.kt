package com.example.keys.server

import kotlinx.serialization.Serializable
import java.time.LocalDate


@Serializable
data class FormCreateParams(
    val name: String,
    val description: String,
    val date: String,
    val periodId: Int,
    val keyId: Int
)