package com.example.keys.forms

import com.example.keys.my_enum.StatusForm
import com.example.keys.my_enum.StatusKey

data class Forms(
    val id: Long, // Уникальный номер пользователя
    val name: String, // Имя человека
    //val description: String, // Название комании
    val data: String, // Ссылка на фото человека
    val time: String,
    val room: Int,
    val statusForm: StatusForm,
    val statusKey: StatusKey,
    val isKey: Boolean // Был ли лайкнут пользователь
)
