package com.tooploox.androidrecruitmenttask.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tooploox.androidrecruitmenttask.domain.Song

@Composable
fun SongsView(
    songs: List<Song>,
    onSongClick: (Song) -> Unit,
) {
    LazyColumn {
        items(items = songs) {
            SongItemView(
                song = it,
                onClick = onSongClick,
            )
        }
    }
}

@Composable
private fun SongItemView(
    song: Song,
    onClick: (Song) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { onClick(song) })
            .padding(16.dp)
    ) {
        Text(song.artist)
        Text(song.title)
    }
}