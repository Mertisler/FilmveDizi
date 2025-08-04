package com.loc.filmvedizi

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@OptIn( ExperimentalMaterial3Api::class)
@Composable
fun MovieSearchBar(
    onQueryChange: (String) -> Unit
) {
    var query by remember { mutableStateOf("") }

    SearchBar(
        query = query,
        onQueryChange = {
            query = it
            onQueryChange(it)
        },
        onSearch = {
            onQueryChange(query)
        },
        active = true,
        onActiveChange = {},
        placeholder = { Text("Film ara...") }
    ) {}
}
