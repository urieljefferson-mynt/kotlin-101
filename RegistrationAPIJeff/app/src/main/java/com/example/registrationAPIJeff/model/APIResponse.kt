package com.example.registrationAPIJeff.model

import com.google.gson.annotations.SerializedName

class UserVerificationResponse{
    @SerializedName("is_existing")
    var is_existing: Boolean = false
}
