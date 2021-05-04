package com.example.registrationAPIJeff

data class CartItem (
    val itemName: String,
    var price: Double,
    var quantity: Int?,
    var isChecked: Boolean = false
)