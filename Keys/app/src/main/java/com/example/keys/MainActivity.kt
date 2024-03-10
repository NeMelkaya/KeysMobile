package com.example.keys

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.keys.databinding.ActivityMainBinding
import com.example.keys.databinding.ActivitySingUpBinding
import com.example.keys.forms.form.FormActivity


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val strUser = intent.getStringExtra("LLuser")?: "aaaaaa"
        val strExpiration = intent.getStringExtra("LLexpiration")?: "aaaaaa"
        val token = TokenStore.token
        Toast.makeText(this@MainActivity, "token: ${TokenStore.token}", Toast.LENGTH_SHORT).show()


        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.fragmentContainer, FormFragment.newInstance(), FormFragment.TAG)

            }
        }

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.actionKeys -> {
                    selectScreen(KeysFragment.TAG, KeysFragment.newInstance())
                    true
                }
                R.id.actionForm -> {
                    selectScreen(FormFragment.TAG, FormFragment.newInstance())
                    true
                }

                R.id.actionTimetable -> {
                    val intent = Intent(this, FormActivity::class.java)
                    startActivity(intent)
                    true

                }
                R.id.actionProfile -> {
                    selectScreen(ProfileFragment.TAG, ProfileFragment.newInstance())
                    true
                }
                else -> false
            }
        }
    }

    private fun selectScreen(tag:String, fragment: Fragment){
        supportFragmentManager.commit {
            val active = findActiveFragment()
            val target = supportFragmentManager.findFragmentByTag(tag)

            if(active != null && target != null && active == target) return@commit

            if (active != null){
                hide(active)
            }
            if(target == null){
                add(R.id.fragmentContainer, fragment, tag)
            } else{
                show(target)
            }
        }
    }
    private fun findActiveFragment() = supportFragmentManager.fragments.find { it.isVisible }

    fun selectHome(){
        binding.bottomNavigation.selectedItemId = R.id.actionForm
    }



    //override fun onCreate(savedInstanceState: Bundle?) {
       // super.onCreate(savedInstanceState)

        //binding.button.setOnClickListener {
        //    binding.text.setText("Hello Pasha!")
        //}

   // }
}