package com.tooploox.androidrecruitmenttask

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SongsScreen() {
    val viewModel: MainViewModel = viewModel()
    val songs by viewModel.songs.collectAsState()
    var detailsClicked by remember { mutableStateOf(false) }
    var selectedSong: Song? by remember { mutableStateOf(null) }
    if (!detailsClicked) {
        Column(Modifier.verticalScroll(rememberScrollState())) {
            songs.forEach {
                Box(modifier = Modifier.clickable {
                    selectedSong = it
                    detailsClicked = true
                }) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(it.artist)
                        Text(it.title)
                        Text(it.releaseYear.toString())
                    }
                }

            }
        }
    } else {
        Column(modifier = Modifier.fillMaxWidth()) {
            selectedSong?.let {
                Text("What a great detalis page!")
                Text(it.artist)
                Text(it.title)
                Text(it.releaseYear.toString())
            }
        }
        Button(onClick = { detailsClicked = false }) { Text("Back") }

    }
}