package com.example.fp_bpii.response.users

data class RegisterRespnse(
    val success: Boolean,
    val message: String,
    val `data`: Data? // Jika ada data pengguna yang dikembalikan
)
