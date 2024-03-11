package com.example.keys.server

import com.example.keys.TokenStore

class FormCreateController {
    private val api: IFormCreate = Network.retrofit.create(IFormCreate::class.java)

    suspend fun formCreate(formCreate: FormCreateParams) = runCatching {
        api.getFormCreate(TokenStore.allToken, formCreate)
    }
}