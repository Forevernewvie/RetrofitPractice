package com.jaebin.mixded

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitClass {
    private val baseURl = API.baseUrl
    private val retrofit:Retrofit = Retrofit.Builder()
        .baseUrl(baseURl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: GitHubClient = retrofit.create(
        GitHubClient::class.java
    )






}