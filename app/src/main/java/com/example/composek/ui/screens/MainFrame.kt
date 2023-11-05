package com.example.composek.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.composek.model.entity.NavigationItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainFrame() {

    val navigationItems = listOf(
        NavigationItem("学习", icon = Icons.Filled.Home),
        NavigationItem("任务", icon = Icons.Filled.DateRange),
        NavigationItem("我的", icon = Icons.Filled.Person),
    )

    var currentNavigationIndex by remember {
        mutableStateOf(0)
    }

    Scaffold(bottomBar = {
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = Color(0x149EE7),
            modifier = Modifier.navigationBarsPadding()
        ) {
            navigationItems.forEachIndexed { index, navigationItem ->
                NavigationBarItem(selected = currentNavigationIndex == index,
                    onClick = {
                        currentNavigationIndex = index
                    }, icon = {
                        Icon(imageVector = navigationItem.icon, contentDescription = null)
                    }, label = {
                        Text(text = navigationItem.title)
                    }
                )
            }
        }
    }) {
        Box(modifier = Modifier.padding(it)){
            when(currentNavigationIndex){
                0 -> StudyScreen()
                1 -> TaskScreen()
                2 -> MineScreen()
            }
        }

    }
}

@Preview
@Composable
fun MainFramePreview() {
    MainFrame()
}