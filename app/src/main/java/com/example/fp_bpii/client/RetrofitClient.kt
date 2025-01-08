package com.example.fp_bpii.client

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    // URL API base
    const val BASE_URL = "http://172.25.206.48/rest_apibp2/index.php/"

    // Instance Retrofit yang diciptakan secara lazy (hanya dibuat sekali)
    val instance: Api by lazy {
        // Membuat Retrofit dengan URL base dan converter Gson
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)  // URL API base
            .addConverterFactory(GsonConverterFactory.create())  // Konverter untuk response JSON ke model
            .build()

        // Membuat instansi Api untuk memanggil API
        retrofit.create(Api::class.java)
    }
}
