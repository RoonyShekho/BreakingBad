package com.example.breakingbad.ui.presentation.characters


import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.breakingbad.model.CharacterItem
import com.example.breakingbad.ui.navigation.MainRoutes
import com.example.breakingbad.ui.presentation.SharedViewModel
import com.example.breakingbad.ui.presentation.searchview.SearchBar
import com.example.breakingbad.ui.presentation.searchview.SearchDisplay
import com.example.breakingbad.ui.presentation.searchview.SearchState
import com.example.breakingbad.ui.presentation.searchview.rememberSearchState
import com.example.breakingbad.util.LoadImage
import kotlinx.coroutines.delay

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CharactersScreen(
    navController: NavHostController,
    vm: CharactersViewModel = hiltViewModel(),
    sharedVm: SharedViewModel,
    state: SearchState = rememberSearchState()
) {

    val items by vm.items

    val listState = rememberLazyListState()


    LazyColumn(
        verticalArrangement = Arrangement.SpaceBetween,
        state = listState
    ) {

        item {
            SearchBar(
                query = state.query,
                onQueryChange = {
                    state.query = it
                                },
                onSearchFocusChange = { state.focused = it },
                onClearQuery = { state.query = TextFieldValue("") },
                onBack = { state.query = TextFieldValue("") },
                searching = state.searching,
                focused = state.focused
            )
        }

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

    LaunchedEffect(state.query.text) {
        state.searching = true
        delay(100)
        state.searchResults = vm.items.value
        state.searching = false
    }


    when(state.searchDisplay){
        SearchDisplay.NoResults -> {
            vm.getCharacters()
        }

        SearchDisplay.Results -> {
            vm.searchCharacter(state.query.text)
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