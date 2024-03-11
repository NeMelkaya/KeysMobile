package com.example.keys.server

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class FormResponse(
    val id: Int,
    val name: String,
    val description: String,
    val date: String,
    val periodId: Int,
    val keyId: Int,
    val owner: String,
    val state: List<Int>,
    val isRepeated: Boolean,
)