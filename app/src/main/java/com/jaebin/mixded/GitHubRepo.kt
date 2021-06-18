package com.jaebin.mixded

import com.google.gson.annotations.SerializedName

data class GitHubRepo(
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description : String,
    @SerializedName("language")
    val lanuguage: String?


)
