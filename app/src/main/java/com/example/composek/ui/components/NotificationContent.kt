package com.example.composek.ui.components


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composek.viewmodel.MainViewModel
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import java.util.Timer
import java.util.TimerTask

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NotificationContent(vm: MainViewModel) {

    // 虚拟页数
    val virtualCount = Int.MAX_VALUE

    // 实际页数
    val actualCount = vm.notifications.size

    // 初始图片下标
    val initialIndex = virtualCount / 2

    var pagerState = rememberPagerState(initialPage = initialIndex)

    var coroutineScope = rememberCoroutineScope()

    DisposableEffect(Unit) {
        val timer = Timer()

        timer.schedule(object : TimerTask() {
            override fun run() {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                }
            }
        }, 3000, 3000)

        onDispose {
            timer.cancel()
        }
    }

    Row(
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0x22149ee7))
            .height(45.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = "最新活动", color = Color(0xff149ee7), fontSize = 14.sp)
        Spacer(modifier = Modifier.width(8.dp))
        VerticalPager(
            count = initialIndex,
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.Start,
            state = pagerState
        ) { index ->
            val actualIndex = (index - initialIndex).floorMod(actualCount)
            Text(
                text = vm.notifications[actualIndex],
                color = Color(0xff333333),
                fontSize = 14.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "更多", color = Color(0xff333333), fontSize = 14.sp, maxLines = 1
        )
        Spacer(modifier = Modifier.width(4.dp))
    }
}

private fun Int.floorMod(other: Int): Int = when (other) {
    0 -> this
    else -> this - floorDiv(other) * other
}

@Preview
@Composable
fun NotificationContentPreview() {

}

