package com.example.aidrawing.ui.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.aidrawing.R

@Composable
fun SearchButton(modifier: Modifier, onClick: () -> Unit,) {

    IconButton(
        onClick = {},
        modifier = Modifier
            .background(color = Color(0xFF1DA1F2))
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_search),
            contentDescription = "Click to share",
            tint = Color.Black
        )
    }
}
