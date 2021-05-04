package com.example.registrationAPIJeff

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

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