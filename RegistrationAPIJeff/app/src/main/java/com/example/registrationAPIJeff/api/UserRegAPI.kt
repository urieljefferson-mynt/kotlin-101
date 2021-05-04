package com.example.registrationAPIJeff.api

import com.example.registrationAPIJeff.model.UserVerificationResponse
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response


import retrofit2.http.*

interface UserRegAPI {

        @POST("android_registration_jefferson/")
        suspend fun createUser(@Body requestBody: RequestBody): Response<ResponseBody>

}