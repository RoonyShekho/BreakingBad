package com.example.breakingbad.data.remote

import com.example.breakingbad.model.CharacterItem
import com.example.breakingbad.model.EpisodeItem
import retrofit2.http.GET


interface BreakingBadApi {

    @GET("/api/characters")
    suspend fun getCharacters():ArrayList<CharacterItem>


    @GET("/api/episodes")
    suspend fun getEpisodes():ArrayList<EpisodeItem>
}