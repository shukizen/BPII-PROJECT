package com.example.fp_bpii.response.users

import android.os.Message

data class LoginResponse(
    val success : Boolean,
    val message: String,
    val `data`: Data
)
