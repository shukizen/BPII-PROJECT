package com.example.fp_bpii.response.users

import java.sql.Time

data class PsikiaterResponse(

    val foto_ahli: String,
    val nama_ahli: String,
    val spesialis: String,
    val jam_kerja: Time,
    val pengalaman: String
)
