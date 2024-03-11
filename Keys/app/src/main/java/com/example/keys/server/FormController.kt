package com.example.keys.server

import com.example.keys.TokenStore

class FormController {
    private val api: IForm = Network.retrofit.create(IForm::class.java)

    suspend fun form(form: FormParams) = runCatching {
        api.getForm(TokenStore.allToken, form)
    }
}