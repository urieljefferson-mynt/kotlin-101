package com.example.registrationAPIJeff.api

import android.util.Log
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.RequestBody
import retrofit2.Retrofit

object UserRegistrationApiClient {

    val BASE_URL = "https://r0zkyg41pc.execute-api.ap-southeast-1.amazonaws.com/default/"

    fun createUser(requestBody: RequestBody){

            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .build()

            val service = retrofit.create(UserRegAPI::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            // Do the POST request and get response
            Log.d("POST REQUEST", "SENDING")
            val response = service.createUser(requestBody)
            Log.d("POST REQUEST", "SUCCESS")
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    // Convert raw JSON to pretty JSON using GSON library
                    val gson = GsonBuilder().setPrettyPrinting().create()
                    val prettyJson = gson.toJson(
                        JsonParser.parseString(
                            response.body().toString()
                               // About this thread blocking annotation : https://github.com/square/retrofit/issues/3255
                        )
                    )

                    Log.d("Pretty Printed JSON :", prettyJson)

                } else {

                    Log.e("RETROFIT_ERROR", response.code().toString())

                }
            }
        }
    }
}