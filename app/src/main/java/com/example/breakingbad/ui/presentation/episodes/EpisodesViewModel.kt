package com.example.breakingbad.ui.presentation.episodes

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.breakingbad.data.repository.Repository
import com.example.breakingbad.model.EpisodeItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodesViewModel @Inject constructor(
    private val repository: Repository
):ViewModel() {

    val items = mutableStateOf<ArrayList<EpisodeItem>>(arrayListOf())


    init {
        viewModelScope.launch {
            items.value = repository.getEpisodes()
        }
    }

}