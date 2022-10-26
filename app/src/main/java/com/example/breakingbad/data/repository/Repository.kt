package com.example.breakingbad.data.repository

import com.example.breakingbad.data.remote.BreakingBadApi
import com.example.breakingbad.model.CharacterItem
import com.example.breakingbad.model.EpisodeItem
import javax.inject.Inject

class Repository @Inject constructor(
    private val api: BreakingBadApi
) {


    suspend fun getCharacters(): ArrayList<CharacterItem> {
        return api.getCharacters()
    }


    suspend fun getEpisodes(): ArrayList<EpisodeItem> {
        return api.getEpisodes()
    }

}