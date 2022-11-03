package com.example.breakingbad.ui.presentation.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.google.android.material.chip.ChipGroup

@Composable
fun Chip(
    name: String,
    isSelected: Boolean,
    onSelectedChanged: (String) -> Unit = {}
) {


    Surface(
        modifier = Modifier.padding(4.dp),
        shadowElevation = 8.dp,
        color = if (isSelected) Color.LightGray else MaterialTheme.colorScheme.primary
    ) {

        Row(modifier = Modifier.toggleable(
            value = isSelected,
            onValueChange = {
                onSelectedChanged(name)
            }
        )) {
            Text(
                text = name,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}


@Composable
fun ChipGroup(
    chips: List<Chips> = getChips(),
    selectedChip: Chips? = null,
    onSelectedChanged: (String) -> Unit = {}
) {

    Column(modifier = Modifier.padding(8.dp)) {
        LazyRow {
            items(chips) {
                Chip(name = it.value, isSelected = selectedChip == it, onSelectedChanged = {
                    onSelectedChanged(it)
                })
            }
        }
    }

}

enum class Chips(val value: String) {
    BREAKING_BAD("breaking bad"),
    BETTER_CALL_SAUL("better call saul")
}

fun getChips(): List<Chips> {
    return listOf(Chips.BETTER_CALL_SAUL, Chips.BREAKING_BAD)
}

fun getChip(value: String): Chips? {
    val map = Chips.values().associateBy(Chips::value)
    return map[value]
}






