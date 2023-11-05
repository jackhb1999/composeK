package com.example.composek.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel() {
    var taskDate by mutableStateOf("学习周期：2023.11.05-2023.12.01")
        private set

    var totalPointOfYear = 25000

    // 学年积分
    var pointOfYear by mutableStateOf(10000)
        private set

    // 学年积分进度 = 220f * pointOfYear / 学年积分
    var pointOfYearPercent by mutableStateOf(0f)
        private set

    /**
     * 更新学年积分进度
     */
    fun updatePointOfYearPercent() {
        pointOfYearPercent = 220f * pointOfYear / totalPointOfYear
    }
}
