package com.example.keys.server

import com.example.keys.TokenStore

class UserController {
    private val api: IUser = Network.retrofit.create(IUser::class.java)

    suspend fun user() = runCatching {
        api.getUser(TokenStore.allToken, TokenStore.id)
    }
}