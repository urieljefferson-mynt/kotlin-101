package com.example.ecommercejeff

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.replace
import kotlinx.android.synthetic.main.list_items.*
import kotlinx.android.synthetic.main.registration_form.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val registrationForm = RegistrationForm()


        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment, registrationForm)
            commit()
        }
    }
}