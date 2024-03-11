package com.example.keys.forms

import com.example.keys.my_enum.StatusForm
import com.example.keys.my_enum.StatusKey
import com.example.keys.server.FormResponse
import com.example.keys.server.IForm

typealias FormsListener = (forms: List<Forms>) -> Unit

class FormsService {
    private var allForms = mutableListOf<Forms>()

    // Класс чтобы управлять данными

    private val listeners = mutableSetOf<FormsListener>()

    init {
//        allForms = (1..5).map {
//            Forms(
//                id = it.toLong(),
//                name = "name",
//                data = "11.01.2024", // Ссылка на фото человека
//                time = "8:45 - 10:20",
//                room = 111,
//                statusForm = StatusForm.WAIT,
//                statusKey = StatusKey.NO,
//                isKey = false
//            )
//        }.toMutableList()
    }
    fun getForms(allforms: List<FormResponse>) : List<Forms>{
        allForms = (1..allforms.size).map {
            Forms(
                id = allforms[it].id,
                name = allforms[it].name,
                description = allforms[it].description,
                data = allforms[it].date, // Ссылка на фото человека
                time = allforms[it].periodId,
                room = allforms[it].keyId,
                statusForm = allforms[it].state,
                statusKey = allforms[it].owner,
                isKey = allforms[it].isRepeated
            )
        }.toMutableList()

        return allForms
    }

    fun deleteForms(form : Forms){
        val indexToDelete : Int = allForms.indexOfFirst { it.id == form.id }
        if (indexToDelete != -1){
            allForms.removeAt(indexToDelete)
            notifyChanger()
        }
    }

    fun getTheKey(form: Forms){
        val index = allForms.indexOfFirst { it.id == form.id } // Находим индекс формы в списке
        if (index == -1) return // Останавливаемся, если не находим такого формы

        allForms = ArrayList(allForms) // Создаем новый список
        allForms[index] = allForms[index].copy(isKey = !allForms[index].isKey) // Меняем значение "ключа" на противоположное
        notifyChanger()
    }

    fun addListener(listener: FormsListener){
        listeners.add(listener)
        listener.invoke(allForms)
    }

    fun removeListener(listener: FormsListener){
        listeners.remove(listener)
    }

    private fun notifyChanger(){
        listeners.forEach { it.invoke(allForms) }
    }


}



