package com.tooploox.androidrecruitmenttask

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SongsScreen() {
    val viewModel: MainViewModel = viewModel()
    val songs by viewModel.songs.collectAsState()
    Column(Modifier.verticalScroll(rememberScrollState())) {
        songs.forEach {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(it.artist)
                Text(it.title)
            }
        }
    }
}
