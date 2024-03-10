package com.example.keys.forms.form

import com.example.keys.forms.Forms

interface FormActionListener {
    fun onFormGetId(form: Forms)
    fun onFormGetKey(form: Forms)

}