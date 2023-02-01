package com.example.aidrawing.data.remote.responsess

import com.example.aidrawing.data.models.TweetEntry

data class Data(
    val edit_history_tweet_ids: List<String>,
    val id: String,
    val text: String
) {
    fun dataToTweetEntry(): TweetEntry {
        return TweetEntry(
            id = id,
            text = text
        )
    }
}