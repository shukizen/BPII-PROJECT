package com.example.fp_bpii.client

import com.example.fp_bpii.response.users.LoginResponse
import com.example.fp_bpii.response.users.PsikiaterResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @GET("psikiater")
    fun getPsikiater() : Call<ArrayList<PsikiaterResponse>>
    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    abstract fun postLogin(user: String, pwd: String): Any
}