package com.example.aidrawing.repository

import android.util.Log
import com.example.aidrawing.data.remote.TwitterApi
import com.example.aidrawing.data.remote.responsess.Data
import com.example.aidrawing.data.remote.responsess.Tweets
import com.example.aidrawing.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@ActivityScoped
class TweetRepository @Inject constructor(
    private val api: TwitterApi
) {

    suspend fun getAllTweets(userid: String, count: Int): Flow<Resource<List<Tweets>>> = flow {
        try {
            emit(Resource.Loading<List<Tweets>>())
            val response = api.getTweetList(userid, count)
            val tweetsList = mutableListOf<Tweets>()
            tweetsList.add(response)
            var responseNextToken = response.meta.next_token
            while (responseNextToken != null && tweetsList.size < 10) {
                val nextResponse = api.getNextTweetList(userid, count, responseNextToken)
                tweetsList.add(nextResponse)
                responseNextToken = nextResponse.meta.next_token
            }
            emit(Resource.Success<List<Tweets>>(tweetsList))
        } catch (e: IOException) {
            emit(Resource.Error<List<Tweets>>("Please check your internet connection."))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Tweets>>("Error: " + e.message))
        } catch (e: Exception) {
            emit(Resource.Error<List<Tweets>>("An unknown error occured."))
        }
    }
}