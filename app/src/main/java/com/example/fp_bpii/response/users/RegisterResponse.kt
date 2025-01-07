package com.example.fp_bpii.response.users

data class RegisterResponse(
    val status: Boolean,
    val message: String,
    val data: Data
) {
    data class Data(
        val email: String,
        val username: String,
        val password: String
    )
}
