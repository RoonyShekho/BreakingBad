package com.example.breakingbad.ui.presentation.char_details


import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.breakingbad.model.CharacterItem
import com.example.breakingbad.ui.presentation.SharedViewModel
import com.example.breakingbad.util.LoadImage


@Composable
fun CharDetails(
    sharedVm: SharedViewModel
) {
    val character = sharedVm.characterItem.value

    CharacterDetails(character!!)
}


@Composable
fun CharacterDetails(
    character: CharacterItem
) {

    Column(
        horizontalAlignment = CenterHorizontally
    ) {

        Text(
            text = character.name,
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "(${character.nickname.uppercase()})",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        LoadImage(
            url = character.img,
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp)
                .padding(bottom = 12.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        StatusButton(character.status)
    }
}

@Composable
fun StatusButton(status: String) {
    val color = when (status) {
        "Alive" -> {
            Green
        }
        "Deceased", "Presumed dead" -> {
            Red
        }
        else -> {
            Color.LightGray
        }
    }

    Surface(
        shape = RoundedCornerShape(20.dp),
        color = color,
        modifier = Modifier
            .height(50.dp)
            .width(200.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = status.uppercase(),
                color = White,
                modifier = Modifier.align(CenterHorizontally),
                fontStyle = MaterialTheme.typography.bodyMedium.fontStyle,
                fontWeight = FontWeight.Bold
            )
        }
    }

/*    Button(
        enabled = false, onClick = {}, modifier = Modifier.background(color = color)
    ) {
        Text(text = status.uppercase())
    }*/
}





