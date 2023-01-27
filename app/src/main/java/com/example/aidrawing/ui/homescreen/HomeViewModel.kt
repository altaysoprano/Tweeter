package com.example.aidrawing.ui.homescreen

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.aidrawing.DiscordModel
import com.example.aidrawing.common.Constants
import com.example.aidrawing.common.Constants.CHANNEL_ID
import com.example.aidrawing.common.Constants.TOKEN
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.N)
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val discordModel: DiscordModel
) : ViewModel() {

    private val _isHeaderVisible = mutableStateOf<Boolean>(true)
    val isHeaderVisible: State<Boolean> = _isHeaderVisible

    init {

    }

}