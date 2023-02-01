package com.example.aidrawing.data.remote

import com.example.aidrawing.common.Constants.TOKEN
import com.example.aidrawing.data.remote.responsess.Tweets
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface TwitterApi {

    @GET("users/{id}/tweets")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun getTweetList(
        @Path("id") id: String,
        @Query("max_results") count: Int
    ): Tweets

    @GET("users/{id}/tweets")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun getNextTweetList(
        @Path("id") id: String,
        @Query("max_results") count: Int,
        @Query("pagination_token") nextToken: String
    ): Tweets

}