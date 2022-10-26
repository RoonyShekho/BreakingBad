package com.example.breakingbad.ui.presentation.characters


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.breakingbad.model.CharacterItem
import com.example.breakingbad.ui.navigation.MainRoutes
import com.example.breakingbad.ui.presentation.SharedViewModel
import com.example.breakingbad.util.LoadImage

@Composable
fun CharactersScreen(
    navController: NavHostController,
    vm: CharactersViewModel = hiltViewModel(),
    sharedVm:SharedViewModel
) {

    val items by vm.items
    val state = rememberLazyListState()



    LazyColumn(
        verticalArrangement = Arrangement.SpaceBetween,
        state = state
    ) {
        item {
            Spacer(Modifier.windowInsetsTopHeight(WindowInsets.statusBars))
        }
        


        items(items) {
            CharacterItem(item = it) {
                sharedVm.setCharacter(it)
                navController.navigate(MainRoutes.CharacterDetails.route)
            }
        }
    }
}


@Composable
fun CharacterItem(
    item: CharacterItem,
    onClick: () -> Unit
) {
    Surface(
        shadowElevation = 2.dp,
        tonalElevation = 2.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    top = 16.dp,
                    end = 16.dp,
                    bottom = 8.dp
                )
                .clickable(onClick = onClick)
        ) {

            LoadImage(
                url = item.img, modifier = Modifier
                    .size(150.dp)
                    .padding(end = 6.dp)
            )


            Column {
                Text(
                    text = item.name,
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(
                    text = "(${item.nickname.uppercase()})",
                    style = MaterialTheme.typography.headlineSmall,
                )
            }
        }
    }
}