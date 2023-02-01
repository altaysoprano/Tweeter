package com.example.aidrawing.di

import com.example.aidrawing.DiscordModel
import com.example.aidrawing.common.Constants.BASE_URL
import com.example.aidrawing.data.remote.TwitterApi
import com.example.aidrawing.repository.TweetRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideTweetRepository(
        api: TwitterApi
    ) = TweetRepository(api)

    @Singleton
    @Provides
    fun provideTwitterApi(): TwitterApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(TwitterApi::class.java)
    }
}