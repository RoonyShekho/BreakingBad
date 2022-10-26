package com.example.breakingbad

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.breakingbad.ui.navigation.MyBottomBar
import com.example.breakingbad.ui.navigation.ScreenTabs
import com.example.breakingbad.ui.navigation.SetupNavGraph
import com.example.breakingbad.ui.presentation.SharedViewModel
import com.example.breakingbad.ui.theme.BreakingBadTheme


@ExperimentalMaterial3Api
@Composable
fun BreakingBadApp(vm:SharedViewModel = viewModel()) {

    BreakingBadTheme {

        val navController = rememberNavController()

        val tabs = remember { ScreenTabs.values() }


        Scaffold(
            bottomBar = {
                MyBottomBar(navController = navController, tabs = tabs)
            }
        ) {
            Spacer(modifier = Modifier.padding(it))

            SetupNavGraph(navController = navController, vm = vm)
        }
    }
}




