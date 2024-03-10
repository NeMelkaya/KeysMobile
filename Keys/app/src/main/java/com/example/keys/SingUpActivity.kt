package com.example.keys

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.keys.databinding.ActivityLoginBinding
import com.example.keys.databinding.ActivitySingUpBinding
import com.example.keys.server.SignUpController
import com.example.keys.server.SignUpParams
import kotlinx.coroutines.launch

class SingUpActivity : AppCompatActivity(R.layout.activity_sing_up) {

    private val binding by viewBinding(ActivitySingUpBinding::bind)
    val controller = SignUpController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.loginBtn.setOnClickListener {
            //Toast.makeText(this@SingUpActivity, "click", Toast.LENGTH_SHORT).show()

            lifecycleScope.launch {

                val res = controller.signUp(

                    SignUpParams(
                        username = binding.nameText.text.toString(),
                        email = binding.loginText.text.toString(),
                        password = binding.passwordText.text.toString()

                    )

                )
                Toast.makeText(this@SingUpActivity, "click", Toast.LENGTH_SHORT).show()
                if (res.isSuccess) {
                    Toast.makeText(this@SingUpActivity, "uspex", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@SingUpActivity, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    ///
                    Toast.makeText(this@SingUpActivity, "neuspex", Toast.LENGTH_SHORT).show()
                    res.exceptionOrNull()?.printStackTrace()

                }

//                res.onSuccess { //data ->
//                    //что будет при успехе
//                    val intent = Intent(this@SingUpActivity, MainActivity::class.java)
////                    intent.putExtra( "Pasha", "data.name")
////                    intent.putExtra( "Pasha2", "data.name")
////                    intent.putExtra( "Pasha3", "data.name")
////                    TokenStore.token = "data.name"
//                    startActivity(intent)
//
//                }
//                res.onFailure {

                //}
            }


        }

        binding.botSecondTV.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}