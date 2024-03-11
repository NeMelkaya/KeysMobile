package com.example.keys

import android.R.attr.value
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.keys.databinding.FragmentProfileBinding
import com.example.keys.server.LoginController
import com.example.keys.server.LoginParams
import com.example.keys.server.UserController
import com.example.keys.server.UserParams
import com.google.android.material.chip.Chip
import kotlinx.coroutines.launch


class ProfileFragment: Fragment(R.layout.fragment_profile) {
    companion object {
        val TAG = ProfileFragment::class.java.simpleName
        fun newInstance() = ProfileFragment()
    }

    val controller = UserController()

    private val binding by viewBinding(FragmentProfileBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {

            val res = controller.user()

            res.onSuccess { data ->
                //что будет при успехе
                binding.textView2.text = data.userName
//                if(data.roles[0] != "") {
//                    binding.textView3.text = data.roles[0]
//                }
                Toast.makeText(context, "tut: ${data.roles}", Toast.LENGTH_SHORT).show()
            }
            res.onFailure {
                res.exceptionOrNull()?.printStackTrace()
                Toast.makeText(context, "Netoken: ${TokenStore.id}", Toast.LENGTH_SHORT).show()
            }
        }

        binding.exitBtn.setOnClickListener{
            val intent = Intent(context, LoginActivity::class.java)
            //intent.putExtra("key", value)
            startActivity(intent)
        }






     }




}