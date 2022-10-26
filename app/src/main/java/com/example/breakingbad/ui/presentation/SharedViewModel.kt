package com.example.breakingbad.ui.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.breakingbad.model.CharacterItem


class SharedViewModel : ViewModel() {

    var characterItem = mutableStateOf<CharacterItem?>(null)
        private set


    fun setCharacter(character: CharacterItem) {
        characterItem.value = character
    }
}