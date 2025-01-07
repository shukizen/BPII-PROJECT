package com.example.fp_bpii.response.users

data class Penyakit(
    val gambar: String,    // Nama file gambar (contoh: "image1.png")
    val jenis_penyakit: String, // Nama penyakit
    val pengertian: String, // Penjelasan mengenai penyakit
    val gejala: String,// Penjelasan mengenai penyakit
    val pengobatan: String // Penjelasan mengenai penyakit
)
