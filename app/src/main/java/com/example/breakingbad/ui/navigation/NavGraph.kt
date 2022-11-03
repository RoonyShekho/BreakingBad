package com.example.breakingbad.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.breakingbad.ui.presentation.SharedViewModel
import com.example.breakingbad.ui.presentation.char_details.CharDetails
import com.example.breakingbad.ui.presentation.characters.CharactersScreen
import com.example.breakingbad.ui.presentation.episodes.EpisodesScreen


@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination:String = MainRoutes.Characters.route,
    vm:SharedViewModel
) {

    NavHost(navController = navController, startDestination = startDestination){


        composable(route  = MainRoutes.Characters.route){
            CharactersScreen(navController = navController, sharedVm = vm)
        }


        composable(route= MainRoutes.Episodes.route){
            EpisodesScreen()
        }



        composable(route = MainRoutes.CharacterDetails.route){
                CharDetails(vm)
        }
    }

}