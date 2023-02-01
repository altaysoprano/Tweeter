package com.example.aidrawing.repository

import com.example.aidrawing.data.remote.TwitterApi
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
){

    suspend fun getAllTweets(userid: String, count: Int): Flow<Resource<Tweets>> = flow {
        try {
            emit(Resource.Loading<Tweets>())
            val response = api.getTweetList(userid, count)
            emit(Resource.Success<Tweets>(response))
        }
        catch (e: IOException) {
            emit(Resource.Error<Tweets>("Please check your internet connection."))
        }
        catch(e: HttpException) {
            emit(Resource.Error<Tweets>("Hata: " + e.response()?.errorBody()?.string()))
        }
        catch (e: Exception) {
            emit(Resource.Error<Tweets>("An unknown error occured."))
        }
    }

}