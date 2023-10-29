package com.example.composek.ui.components


import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.composek.viewmodel.MainViewModel
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import java.util.Timer
import java.util.TimerTask

@Composable
fun SwiperContent(vm: MainViewModel) {

    // 虚拟页数
    val virtualCount = Int.MAX_VALUE

    // 实际页数
    val actualCount = vm.swiperData.size

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

    HorizontalPager(
        count = initialIndex,
        contentPadding = PaddingValues(8.dp),
        modifier = Modifier.clip(RoundedCornerShape(8.dp)),
        state = pagerState
    ) { index ->
        val actualIndex = (index - initialIndex).floorMod(actualCount)
        AsyncImage(
            model = vm.swiperData[actualIndex].imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(7 / 3f), contentScale = ContentScale.Crop
        )
    }
}

private fun Int.floorMod(other: Int): Int = when (other) {
    0 -> this
    else -> this - floorDiv(other) * other
}

@Preview
@Composable
fun SwiperContentPreview() {

}

