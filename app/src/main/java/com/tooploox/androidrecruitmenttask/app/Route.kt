package com.tooploox.androidrecruitmenttask.app

import kotlinx.serialization.Serializable

@Serializable
data object SongList

@Serializable
data class Details(
    val title: String,
    val artist: String
)