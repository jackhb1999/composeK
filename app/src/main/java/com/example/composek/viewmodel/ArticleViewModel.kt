package com.example.composek.viewmodel

import androidx.lifecycle.ViewModel
import com.example.composek.model.entity.ArticleEntity

class ArticleViewModel : ViewModel() {

    // 新闻列表数据
    var list = listOf(
        ArticleEntity(title = "这是一条新闻,123123123123123123123", source = "来源", timestamp = "2023-10-29"),
        ArticleEntity(title = "这是2条新闻", source = "来源2", timestamp = "2023-10-21"),
        ArticleEntity(title = "这是3条新闻", source = "来源3", timestamp = "2023-10-12"),
        ArticleEntity(title = "这是45条新闻", source = "来源4", timestamp = "2023-10-22"),
        ArticleEntity(title = "这是5条新闻", source = "来源5", timestamp = "2023-10-34"),
        ArticleEntity(title = "这是6条新闻", source = "来源6", timestamp = "2023-10-29"),
        ArticleEntity(title = "这是7条新闻", source = "来源7", timestamp = "2023-10-30"),
        ArticleEntity(title = "这是一条新闻,123123123123123123123", source = "来源", timestamp = "2023-10-29"),
        ArticleEntity(title = "这是2条新闻", source = "来源2", timestamp = "2023-10-21"),
        ArticleEntity(title = "这是3条新闻", source = "来源3", timestamp = "2023-10-12"),
        ArticleEntity(title = "这是45条新闻", source = "来源4", timestamp = "2023-10-22"),
        ArticleEntity(title = "这是5条新闻", source = "来源5", timestamp = "2023-10-34"),
        ArticleEntity(title = "这是6条新闻", source = "来源6", timestamp = "2023-10-29"),
        ArticleEntity(title = "这是7条新闻", source = "来源7", timestamp = "2023-10-30"),
        ArticleEntity(title = "这是一条新闻,123123123123123123123", source = "来源", timestamp = "2023-10-29"),
        ArticleEntity(title = "这是2条新闻", source = "来源2", timestamp = "2023-10-21"),
        ArticleEntity(title = "这是3条新闻", source = "来源3", timestamp = "2023-10-12"),
        ArticleEntity(title = "这是45条新闻", source = "来源4", timestamp = "2023-10-22"),
        ArticleEntity(title = "这是5条新闻", source = "来源5", timestamp = "2023-10-34"),
        ArticleEntity(title = "这是6条新闻", source = "来源6", timestamp = "2023-10-29"),
        ArticleEntity(title = "这是7条新闻", source = "来源7", timestamp = "2023-10-30"),
        ArticleEntity(title = "这是一条新闻,123123123123123123123", source = "来源", timestamp = "2023-10-29"),
        ArticleEntity(title = "这是2条新闻", source = "来源2", timestamp = "2023-10-21"),
        ArticleEntity(title = "这是3条新闻", source = "来源3", timestamp = "2023-10-12"),
        ArticleEntity(title = "这是45条新闻", source = "来源4", timestamp = "2023-10-22"),
        ArticleEntity(title = "这是5条新闻", source = "来源5", timestamp = "2023-10-34"),
        ArticleEntity(title = "这是6条新闻", source = "来源6", timestamp = "2023-10-29"),
        ArticleEntity(title = "这是7条新闻", source = "来源7", timestamp = "2023-10-30"),
    )
        private set

}