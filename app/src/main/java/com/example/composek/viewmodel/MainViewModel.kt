package com.example.composek.viewmodel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.SmartDisplay
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.composek.model.entity.Category
import com.example.composek.model.entity.DataType
import com.example.composek.model.entity.SwiperEntity

class MainViewModel : ViewModel() {
    // 分类数据
    val categories by mutableStateOf(
        listOf(
            Category("思想政治"),
            Category("法律法规"),
            Category("职业道德"),
            Category("诚信自律"),
        )
    )

    // 当前分类下标
    var categoryIndex by mutableStateOf(0)
        private set

    // 更新分类下标方法
    fun updateCategoryIndex(index: Int) {
        categoryIndex = index
    }


    // 类型数据
    val types by mutableStateOf(
        listOf(
            DataType("相关资讯", Icons.Default.Description),
            DataType("视频课程", Icons.Default.SmartDisplay),
        )
    )

    var typeIndex by mutableStateOf(0)
        private set

    fun updateTypeIndex(index: Int) {
        typeIndex = index
    }


    // 轮播图数据
    val swiperData = listOf(
        SwiperEntity("https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/e3fa9a7033f4444e944c6cc3b9f55d24~tplv-k3u1fbpfcp-jj-mark:3024:0:0:0:q75.awebp#?w=811&h=440&s=271791&e=png&b=01040a"),
        SwiperEntity("https://docs.bughub.icu/compose/assets/banner2.webp"),
        SwiperEntity("https://docs.bughub.icu/compose/assets/banner3.webp"),
        SwiperEntity("https://docs.bughub.icu/compose/assets/banner4.jpg"),
        SwiperEntity("https://docs.bughub.icu/compose/assets/banner5.jpg")
    )

    // 通知数据
    val notifications = listOf("aaaaaaa", "bbbbbbb", "ccccccc", "ddddddddd")

}