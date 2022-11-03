package com.example.breakingbad.ui.presentation.episodes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.breakingbad.model.EpisodeItem

@Composable
fun EpisodesScreen(
    vm: EpisodesViewModel = hiltViewModel()
) {

    val bcsItems by vm.items
    val state = rememberLazyListState()


    LazyColumn(
        state = state,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        item {
            Spacer(Modifier.windowInsetsTopHeight(WindowInsets.statusBars))
        }

        itemsIndexed(items = bcsItems, key = { _, item -> item.title }) { index, item ->
            Episode(index = index, selectEpisode = { /*TODO*/ }, item = item)
        }


    }

}


@Composable
fun Episode(
    index: Int,
    selectEpisode: () -> Unit,
    item: EpisodeItem
) {

    Row(modifier = Modifier.padding(4.dp)) {
        val stagger = if (index % 2 == 0) 72.dp else 16.dp

        Spacer(modifier = Modifier.width(stagger))


        EpisodeItem(item = item) {
            selectEpisode()
        }
    }
}


@Composable
fun EpisodeItem(
    item: EpisodeItem,
    onClick: () -> Unit
) {

    Surface(
        tonalElevation = 2.dp,
        shadowElevation = 2.dp
    ) {
        Column(
            modifier = Modifier
                .clickable(onClick = onClick)
                .padding(8.dp)
        ) {

            Text(text = item.title, style = MaterialTheme.typography.headlineMedium)

            Text(
                text = "S${item.season}E${item.episode}",
                style = MaterialTheme.typography.bodyMedium
            )


            Spacer(modifier = Modifier.height(12.dp))

            Text(text = "Characters:", modifier = Modifier.padding(bottom = 4.dp))

            Text(text = item.characters.toString())
        }
    }
}