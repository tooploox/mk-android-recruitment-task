package com.tooploox.androidrecruitmenttask.app

import com.tooploox.androidrecruitmenttask.domain.Song
import kotlinx.serialization.Serializable

@Serializable
data object SongList

@Serializable
data class Details(val song: Song)