package com.example.aidrawing.ui.homescreen

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aidrawing.data.models.TweetEntry
import com.example.aidrawing.repository.TweetRepository
import com.example.aidrawing.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.N)
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: TweetRepository
) : ViewModel() {

    private val _homeState = mutableStateOf(HomeState())
    val homeState = _homeState

    private var tweetList = mutableListOf<TweetEntry>()

    init {

    }

    fun getTweets(userid: String, count: Int) {
        viewModelScope.launch {
            repository.getAllTweets(userid, count).onEach { result ->
                when (result) {
                    is Resource.Loading -> {
                        Log.d("Mesaj: ", "Yükleniyor...")
                    }
                    is Resource.Success -> {
                        tweetList.clear()
                        for(i in result.data?.indices!!) {
                            tweetList.addAll(result.data[i].data.map { it.dataToTweetEntry() })
                        }
/*
                        tweetList = result.data?.data?.map { it.dataToTweetEntry() }!!
*/
                        Log.d("Mesaj: ", tweetList.size.toString())
                        Log.d("Mesaj: ", tweetList[tweetList.size-1].text)
                    }
                    is Resource.Error -> {
                        Log.d("Mesaj: ", result.message.toString())
                    }

                }
            }.launchIn(viewModelScope)
        }
    }

    fun onTextChanged(text: String) {
        _homeState.value = _homeState.value.copy(
            searchText = text
        )
    }

    fun onFocusChanged(isFocused: Boolean) {
        _homeState.value = _homeState.value.copy(
            isTextFieldFocused = isFocused
        )
    }


}