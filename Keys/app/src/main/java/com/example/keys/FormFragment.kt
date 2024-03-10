package com.example.keys

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.keys.databinding.FragmentFormBinding
import com.example.keys.databinding.FragmentProfileBinding
import com.example.keys.forms.App

import com.example.keys.forms.Forms
import com.example.keys.forms.FormsAdapterOld
import com.example.keys.forms.FormsListener
import com.example.keys.forms.FormsService
import com.example.keys.forms.form.FormActionListener
import com.example.keys.forms.form.FormActivity

class FormFragment: Fragment (R.layout.fragment_form) {
    companion object {
        val TAG = FormFragment::class.java.simpleName
        fun newInstance() = FormFragment()
    }

    private val binding by viewBinding(FragmentFormBinding::bind)
    private val adapter = FormsAdapterOld(object : FormActionListener {
        override fun onFormGetId(form: Forms) {
            //Toast.makeText(context, "Form ID: ${form.name}", Toast.LENGTH_SHORT).show()
        }
        override fun onFormGetKey(form: Forms) {
            formsService.getTheKey(form)
            Toast.makeText(context, "vzyal: ${form.room}", Toast.LENGTH_SHORT).show()
        }
    })
    private val formsService: FormsService
        get() = (activity?.applicationContext as App).formsService




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.formsRV.adapter = adapter


        formsService.addListener(formsListener)
        adapter.submitList(formsService.getForms())

        binding.createFormBtn.setOnClickListener{
            val intent = Intent(context, FormActivity::class.java)
            startActivity(intent)
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        formsService.removeListener(formsListener)
    }
    private val formsListener: FormsListener = {
        adapter.submitList(it)
    }


}