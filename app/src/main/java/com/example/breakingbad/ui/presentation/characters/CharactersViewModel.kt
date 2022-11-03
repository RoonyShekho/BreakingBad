package com.example.breakingbad.ui.presentation.characters

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.breakingbad.data.repository.Repository
import com.example.breakingbad.model.CharacterItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val repository: Repository
):ViewModel() {

    val items = mutableStateOf<ArrayList<CharacterItem>>(arrayListOf())


    init {
        viewModelScope.launch {
            items.value = repository.getCharacters()
        }
    }


    fun searchCharacter(name:String){
        viewModelScope.launch {
            items.value = repository.getCharacterByName(name)
        }
    }


    fun getCharacters(){
        viewModelScope.launch {
            items.value = repository.getCharacters()
        }
    }

}



