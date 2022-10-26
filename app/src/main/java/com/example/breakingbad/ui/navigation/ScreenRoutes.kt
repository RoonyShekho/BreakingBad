package com.example.breakingbad.ui.navigation

import androidx.annotation.DrawableRes
import com.example.breakingbad.R


sealed class MainRoutes(val route:String) {
   // object MainScreen:MainRoutes("main_screen")
    object CharacterDetails :MainRoutes("character_details")

    object EpisodeDetails:MainRoutes("episode_details/{eps_id}"){
        fun getItemId(id:Int):String{
            return "episode_details/${id}"
        }
    }


    object Characters:MainRoutes("characters_screen")
    object Episodes:MainRoutes("episodes_screen")
}





enum class ScreenTabs(
    val title: String,
    @DrawableRes val icon: Int,
    val route: String
) {
    CHARACTERS("CHARACTER", R.drawable.person, MainRoutes.Characters.route),
    EPISODES("EPISODES", R.drawable.chapter, MainRoutes.Episodes.route)
}