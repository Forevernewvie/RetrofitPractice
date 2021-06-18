package com.jaebin.mixded

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubClient {
    @GET("/users/{owner}/repos")
    fun getReposList(@Path("owner") owner: String) : Call<List<GitHubRepo>>
}