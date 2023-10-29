package com.example.composek.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composek.ui.components.TopAppBar


@Composable
fun MineScreen() {
Text(text = "我的页面")

    Column {
        TopAppBar() {
            Text(text = "我的页面")
        }
        Text(text = "我的页面")

    }
}

@Preview
@Composable
fun MineScreenPreview() {
    MineScreen()
}