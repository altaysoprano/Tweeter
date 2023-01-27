package com.example.aidrawing.di

import com.example.aidrawing.DiscordModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDiscordModel() = DiscordModel()

/*
    @Provides
    @Singleton
    @Named("Hello1String")
    fun provideString1() = "Hello 1"
*/
}