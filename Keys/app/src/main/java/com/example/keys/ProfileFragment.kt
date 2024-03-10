package com.example.keys

import android.R.attr.value
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.keys.databinding.FragmentProfileBinding
import com.google.android.material.chip.Chip


class ProfileFragment: Fragment(R.layout.fragment_profile) {
    companion object {
        val TAG = ProfileFragment::class.java.simpleName
        fun newInstance() = ProfileFragment()
    }

    private val binding by viewBinding(FragmentProfileBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.exitBtn.setOnClickListener{
            val intent = Intent(context, LoginActivity::class.java)
            //intent.putExtra("key", value)
            startActivity(intent)
        }




     }




}