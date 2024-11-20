package com.example.testing

import android. content. Context
import android.util.Patterns

class DataValidator (private val context: Context){

    operator fun invoke(email: String) : Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}