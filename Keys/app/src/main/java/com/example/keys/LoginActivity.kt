package com.example.keys

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.keys.databinding.ActivityLoginBinding
import com.example.keys.databinding.ActivitySingUpBinding
import com.example.keys.server.LoginController
import com.example.keys.server.LoginParams
import com.example.keys.server.SignUpController
import com.example.keys.server.SignUpParams
import kotlinx.coroutines.launch

class LoginActivity: AppCompatActivity(R.layout.activity_login) {
    private val binding by viewBinding(ActivityLoginBinding::bind)

    val controller = LoginController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.loginBtn.setOnClickListener {

            lifecycleScope.launch {

                val res = controller.login(
                    LoginParams(
                        email = binding.loginText.text.toString(),
                        password = binding.passwordText.text.toString()
                    )
                )

                res.onSuccess { data ->
                    //что будет при успехе
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    intent.putExtra( "LLexpiration", data.expiration)
                    intent.putExtra( "LLuser", data.user)
                    Toast.makeText(this@LoginActivity, "token: ${data.token}", Toast.LENGTH_SHORT).show()
                    TokenStore.token = data.token
                    startActivity(intent)
                }
                res.onFailure {
                    res.exceptionOrNull()?.printStackTrace()
                    Toast.makeText(this@LoginActivity, "Netoken: ${TokenStore.token}", Toast.LENGTH_SHORT).show()
                }
            }
        }
        binding.botSecondTV.setOnClickListener{
            val intent = Intent(this, SingUpActivity::class.java)
            startActivity(intent)
        }

    }

}