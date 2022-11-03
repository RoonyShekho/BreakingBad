package com.example.breakingbad.data.remote

import com.example.breakingbad.model.CharacterItem
import com.example.breakingbad.model.EpisodeItem
import retrofit2.http.GET
import retrofit2.http.Query


interface BreakingBadApi {

    @GET("/api/characters")
    suspend fun getCharacters():ArrayList<CharacterItem>


    @GET("/api/episodes")
    suspend fun getEpisodes(
    ):ArrayList<EpisodeItem>


    @GET("api/characters")
    suspend fun getCharacterByName(
        @Query("name") series:String
    ):ArrayList<CharacterItem>

}