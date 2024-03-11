package com.example.keys.server

import com.example.keys.TokenStore

class FormsController {
    private val api: IForms = Network.retrofit.create(IForms::class.java)

    suspend fun forms() = runCatching {
        api.getForms(TokenStore.allToken)
    }
}