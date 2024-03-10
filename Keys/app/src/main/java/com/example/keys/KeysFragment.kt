package com.example.keys

import androidx.fragment.app.Fragment

class KeysFragment: Fragment (R.layout.fragment_keys) {
    companion object {
        val TAG = KeysFragment::class.java.simpleName
        fun newInstance() = KeysFragment()
    }
}