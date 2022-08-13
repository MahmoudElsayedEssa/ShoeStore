package com.udacity.shoestore.models

import androidx.databinding.InverseMethod


@InverseMethod("stringToDouble")
fun doubleToString(value: Double): String {
    return value.toString()
}

fun stringToDouble(value: String): Double {
    return value.toDouble()
}
