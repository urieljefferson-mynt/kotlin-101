package com.example.ecommercejeff

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.registration_form.*
import kotlinx.android.synthetic.main.registration_form.view.*

// TODO: Rename parameter arguments, choose names that match

/**
 * A simple [Fragment] subclass.
 * Use the [RegistrationForm.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegistrationForm : Fragment(R.layout.registration_form)  {
    // TODO: Rename and change types of parameters
    val listItems = ListItems()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.registration_form, container, false)

        view.btn_register.setOnClickListener{
            Log.d("btn_register", "Registered")
            var mFragmentTransaction: FragmentManager = parentFragmentManager
            mFragmentTransaction.beginTransaction().replace(R.id.fl_fragment,listItems).addToBackStack(null).commit()
        }
        return view
        }

    }


