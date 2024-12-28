package com.example.fp_bpii.client

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    const val BASE_URL = "http://10.200.215.42/rest_apibp2/index.php/user"

    val instance:Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        retrofit.create(Api::class.java)
    }
}