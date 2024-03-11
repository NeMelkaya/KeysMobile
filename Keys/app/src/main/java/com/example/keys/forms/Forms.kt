package com.example.keys.forms

import com.example.keys.my_enum.StatusForm
import com.example.keys.my_enum.StatusKey

data class Forms(
    val id: Int, // Уникальный номер пользователя
    val name: String, // Имя человека
    val description: String, // Название комании
    val data: String, // Ссылка на фото человека
    val time: Int,
    val room: Int,
    val statusForm: List<Int>,
    val statusKey: String,
    val isKey: Boolean // Был ли лайкнут пользователь
)
