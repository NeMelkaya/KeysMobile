package com.example.keys.server

class LoginController {
    private val api: ILogin = Network.retrofit.create(ILogin::class.java)

    suspend fun login(login: LoginParams) = runCatching {
        api.getLogin(login)
    }
}