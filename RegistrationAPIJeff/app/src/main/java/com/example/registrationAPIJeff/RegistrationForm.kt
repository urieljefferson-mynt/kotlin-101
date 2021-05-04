package com.example.registrationAPIJeff

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.registrationAPIJeff.api.UserRegistrationApiClient.createUser
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.registration_form.*
import kotlinx.android.synthetic.main.registration_form.view.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import org.json.JSONObject

class RegistrationForm : Fragment(R.layout.registration_form), AdapterView.OnItemSelectedListener {

    val listItems = ListItems()
    lateinit var email_address: EditText

    lateinit var password: EditText

    lateinit var confirm_password: EditText

    lateinit var salutation: Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.registration_form, container, false)
        val salutations = resources.getStringArray(R.array.salutations_array)

        val spinner : Spinner = view.findViewById(R.id.spinner_salutation);
        val adapter: ArrayAdapter<String>? = this.context?.let { ArrayAdapter<String>(it, android.R.layout.simple_spinner_item, salutations) };
        if (adapter != null) {
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        };
        spinner.setAdapter(adapter);





        view.btn_register.setOnClickListener{
            Log.d("btn_register", "Registering")
            email_address = et_email
            password = et_password
            confirm_password = et_confirmpassword
            salutation = spinner_salutation

            Log.d("POST REQUEST", "${email_address.text}")
            Log.d("POST REQUEST", "${password.text}")
            Log.d("POST REQUEST", "${confirm_password.text}")
            Log.d("POST REQUEST", salutation.selectedItem.toString())

            val jsonObject = JSONObject()
            jsonObject.put("email_address", email_address.text.toString())
            jsonObject.put("password", password.text.toString())
            jsonObject.put("salutation", salutation.selectedItem.toString())
            val jsonObjectString = jsonObject.toString()

            Log.d("POST REQUEST", "${password.text.toString() == confirm_password.text.toString()}")

            if(password.text.toString() == confirm_password.text.toString()) {
                val body = RequestBody.create("application/json; charset=utf-8".toMediaTypeOrNull(), jsonObjectString)
                createUser(body)

                var mFragmentTransaction: FragmentManager = parentFragmentManager
                mFragmentTransaction.beginTransaction().replace(R.id.fl_fragment, listItems)
                    .addToBackStack(null).commit()
            } else {
                Log.d("btn_register", "Password confirmation does not match")
                Snackbar.make(it, "Password confirmation does not match", Snackbar.LENGTH_LONG).show()
                confirm_password.text.clear()
                password.text.clear()
                }


            }
        return view
        }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        parent?.getItemAtPosition(position)

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }


}



