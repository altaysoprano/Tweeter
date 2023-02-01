package com.example.aidrawing.ui.homescreen

import com.example.aidrawing.data.models.TweetEntry

data class HomeState(
    val searchText: String = "",
    val isTextFieldFocused: Boolean = false,
    val tweetList: List<TweetEntry> = listOf(),
    val error: String = "",
    val isLoading: Boolean = false
)
