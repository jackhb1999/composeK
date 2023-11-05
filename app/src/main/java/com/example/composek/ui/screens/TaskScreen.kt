package com.example.composek.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composek.ui.components.CircleRing
import com.example.composek.ui.components.appBarHeight
import com.example.composek.viewmodel.TaskViewModel
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun TaskScreen(taskVM: TaskViewModel = viewModel()) {

    // 圆环高度
    var boxWidthDp: Int
    with(LocalConfiguration.current) {
        boxWidthDp = screenWidthDp / 2
    }

    // 当学年积分改变时重新计算百分比
    LaunchedEffect(taskVM.pointOfYear) {
        taskVM.updatePointOfYearPercent()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xff149ee7), Color.White
                    )
                )
            )
    ) {
        // 标题栏
        Row(
            modifier = Modifier
                .statusBarsPadding()
                .height(appBarHeight),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "学习任务",
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 18.sp
            )
        }


        LazyColumn() {
            // 学习周期
            item {
                Text(
                    text = taskVM.taskDate,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 12.sp,
                )

            }

            // 学习进度
            item {

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.height(boxWidthDp.dp)
                ) {
                    // 圆环
                    CircleRing(boxWidthDp)

                    // 进度数据
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = buildAnnotatedString {
                                this.append(taskVM.pointOfYear.toString())
                                withStyle(SpanStyle(fontSize = 12.sp)) {
                                    append("分")
                                }
                            },
                            fontSize = 36.sp, color = Color.White,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            textAlign = TextAlign.Center,
                        )

                        Text(text = "学年积分", fontSize = 12.sp, color = Color.White)
                    }

                }
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = (-36).dp)
                ) {
                    Column {
                        Text(
                            text = "${taskVM.totalPointOfYear}分",
                            fontSize = 16.sp,
                            color = Color.White
                        )

                        Text(
                            text = "学年规定积分",
                            fontSize = 12.sp,
                            color = Color.White
                        )
                    }
                    Column {
                        Text(
                            text = "${taskVM.totalPointOfYear - taskVM.pointOfYear}分",
                            fontSize = 16.sp,
                            color = Color.White
                        )
                        Text(
                            text = "还差",
                            fontSize = 12.sp,
                            color = Color.White
                        )
                    }
                }
            }
        }

    }

}


@Preview
@Composable
fun TaskScreenPreview() {
    TaskScreen()
}