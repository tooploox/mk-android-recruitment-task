package com.tooploox.androidrecruitmenttask.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.tooploox.androidrecruitmenttask.domain.Song
import com.tooploox.androidrecruitmenttask.ui.DetailsView
import com.tooploox.androidrecruitmenttask.ui.SongsView

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    val viewModel: MainViewModel = viewModel()
    val songs by viewModel.songs.collectAsStateWithLifecycle()
    val viewAction by viewModel.viewActionFlow.collectAsStateWithLifecycle()

    when (val action = viewAction) {
        is SongListViewAction.ShowDetails -> navController.navigate(Details(song = action.song))
        null -> Unit
    }

    if (viewAction != null) {
        viewModel.onViewActionHandled()
    }

    NavHost(
        navController = navController,
        startDestination = SongList
    ) {
        composable<SongList> {
            SongsView(
                songs = songs,
                onSongClick = viewModel::onSongClick,
            )
        }

        composable<Details> {
            val song: Song = it.toRoute()
            DetailsView(song = song)
        }
    }
}
