package com.example.keys.server

class SignUpController {
    private val api: ISighUp = Network.retrofit.create(ISighUp::class.java)

    suspend fun signUp(singUp: SignUpParams) = runCatching {
        api.getSignUp(singUp)
    }
}