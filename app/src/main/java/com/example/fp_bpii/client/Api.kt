package com.example.fp_bpii.client

import com.example.fp_bpii.response.Tips
import com.example.fp_bpii.response.users.LoginResponse
import com.example.fp_bpii.response.users.Penyakit
import com.example.fp_bpii.response.users.ProfileResponse
import com.example.fp_bpii.response.users.RegisterResponse
import com.example.fp_bpii.response.users.RegisterRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

    @FormUrlEncoded
    @POST("user")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String,
    ): Call<LoginResponse>


    @FormUrlEncoded
    @POST("register")
    fun registerUser(
        @Field("email") email: String,
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<RegisterResponse>


    @GET("tips")
    fun getTips(): Call<List<Tips>>

    @GET("penyakit")
    fun getPenyakit(): Call<List<Penyakit>>

    @GET("profile")
    fun profile(
        @Field("email") email: String,
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<ProfileResponse>
    }
