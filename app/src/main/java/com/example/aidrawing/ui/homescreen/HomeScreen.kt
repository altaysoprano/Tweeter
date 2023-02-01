package com.example.aidrawing.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.aidrawing.R
import com.example.aidrawing.ui.homescreen.HomeViewModel

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    val homeState = homeViewModel.homeState.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = Modifier
                .size(192.dp)
                .align(CenterHorizontally),
            painter = painterResource(id = R.drawable.twitter_bird),
            contentDescription = "Twitter Bird"
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            "Discover yourself with words, find your frequently used ones",
            style = MaterialTheme.typography.h6
        )
        Spacer(Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
                    .onFocusChanged {
                        if (it.hasFocus) {
                            homeViewModel.onFocusChanged(true)
                        } else {
                            homeViewModel.onFocusChanged(false)
                        }
                    },
                value = homeState.searchText,
                placeholder = {
                    Text(text = "Enter a Twitter username")
                },
                onValueChange = {
                    homeViewModel.onTextChanged(it)
                },
                leadingIcon = {
                    Text(
                        text = "@",
                        style = MaterialTheme.typography.h5,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(CenterVertically)
                    )
                },
                trailingIcon = {
                    IconButton(onClick = {
                        homeViewModel.getTweets("1411330689723736066", 100)
                    }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_search),
                            contentDescription = "Click to Search",
                            tint = Color.Black
                        )
                    }
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0XFF1DA1F2),
                    backgroundColor = if(homeState.isTextFieldFocused) {
                        Color.White
                    } else {
                        Color(0xFFeff3f4)
                    },
                    unfocusedBorderColor = Color.Transparent,
                    trailingIconColor = if(homeState.isTextFieldFocused) {
                        Color(0XFF1DA1F2)
                    } else {
                        Color.LightGray
                    },
                    leadingIconColor = if(homeState.isTextFieldFocused) {
                        Color(0XFF1DA1F2)
                    } else {
                        Color.LightGray
                    }
                ),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(
                    onSearch = {

                    }
                ),
                shape = RoundedCornerShape(8.dp)
            )
        }
    }
}