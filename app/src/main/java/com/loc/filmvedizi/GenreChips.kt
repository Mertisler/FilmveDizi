package com.loc.filmvedizi


import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.loc.filmvedizi.data.Genre

@Composable
fun GenreChips(
    genres: List<Genre>,
    selectedGenreId: Int?,
    onGenreSelected: (Int?) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .horizontalScroll(rememberScrollState())
    ) {

        AssistChip(
            onClick = { onGenreSelected(null) },
            label = { Text("Tümü") },
            colors = AssistChipDefaults.assistChipColors(
                containerColor = if (selectedGenreId == null) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
            ),
            modifier = Modifier.padding(end = 8.dp)
        )

        genres.forEach { genre ->
            AssistChip(
                onClick = { onGenreSelected(genre.id) },
                label = { Text(genre.name) },
                colors = AssistChipDefaults.assistChipColors(
                    containerColor = if (selectedGenreId == genre.id) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
                ),
                modifier = Modifier.padding(end = 8.dp)
            )
        }
    }
}
