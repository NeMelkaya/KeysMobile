package com.example.keys.server

import com.example.keys.forms.Forms
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.text.Normalizer
import java.time.LocalDate

@Serializable
data class FormsResponse(
    val applications: List<FormResponse>
)