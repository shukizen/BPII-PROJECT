package com.example.fp_bpii.response.users

data class RegisterRequest(
    val email: String,
    val username: String,
    val password: String,
)
