package com.example.breakingbad.model


import com.google.gson.annotations.SerializedName



data class CharacterItem(
    @SerializedName("appearance")
    val appearance: List<Int>,
    @SerializedName("category")
    val category: String,
    @SerializedName("img")
    val img: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("nickname")
    val nickname: String,
    @SerializedName("status")
    val status: String
)