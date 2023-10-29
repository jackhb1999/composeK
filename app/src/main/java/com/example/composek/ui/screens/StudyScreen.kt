package com.example.composek.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composek.ui.components.ArticleItem
import com.example.composek.ui.components.NotificationContent
import com.example.composek.ui.components.TopAppBar
import com.example.composek.viewmodel.ArticleViewModel
import com.example.composek.viewmodel.MainViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun StudyScreen(vm: MainViewModel = viewModel(), articleVM: ArticleViewModel = viewModel()) {
    Column {
        // 标题栏
        TopAppBar() {
            Spacer(modifier = Modifier.width(8.dp))
            // 搜索按钮
            Surface(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .weight(1f),
                color = Color(0x33FFFFFF)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(14.dp)
                    )

                    Text(
                        text = "搜索感兴趣的资讯或课程",
                        color = Color.White,
                        fontSize = 12.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            // 学习进度
            Text(text = "学习\n进度", fontSize = 10.sp, color = Color.White)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "36%", fontSize = 12.sp, color = Color.White)
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = null,
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
        }

        // 分类标签
        TabRow(selectedTabIndex = vm.categoryIndex, containerColor = Color(0x66149ee7)) {
            vm.categories.forEachIndexed { index, category ->
                Tab(
                    selected = vm.categoryIndex == index,
                    onClick = {
                        vm.updateCategoryIndex(index)
                    },
                    selectedContentColor = Color(0xff149ee7),
                    unselectedContentColor = Color(0xff666666)
                ) {
                    Text(
                        text = category.title,
                        modifier = Modifier.padding(vertical = 8.dp),
                        fontSize = 14.sp
                    )
                }
            }

        }

        // 分类标签2
        TabRow(selectedTabIndex = vm.typeIndex,
            containerColor = Color.Transparent,
            contentColor = Color(0xff666666),
            indicator = {},
            divider = {}) {
            vm.types.forEachIndexed { index, dataType ->
                LeadingIconTab(selected = vm.typeIndex == index,
                    onClick = {
                        vm.updateTypeIndex(index)
                    },
                    selectedContentColor = Color(0xff149ee7),
                    unselectedContentColor = Color(0xff666666),
                    icon = {
                        Icon(imageVector = dataType.icon, contentDescription = null)
                    },
                    text = {
                        Text(
                            text = dataType.title,
                            modifier = Modifier.padding(vertical = 8.dp),
                            fontSize = 16.sp
                        )
                    })
            }
        }


        LazyColumn() {

            // 轮播图
//        SwiperContent(vm)

            // 通知公告
            item { NotificationContent(vm) }

            // 新闻列表
//            items(articleVM.list.size) { index ->
//                ArticleItem(articleEntity = articleVM.list[index])
//            }

            // 视频列表
        }


    }

}


@Preview
@Composable
fun StudyScreenPreview() {
    StudyScreen()
}