package com.example.composek.model.entity

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * 导航栏对象
 */
data class NavigationItem(
    val title: String,  // 导航栏标题
    val icon: ImageVector // 底部导航栏图标
)
