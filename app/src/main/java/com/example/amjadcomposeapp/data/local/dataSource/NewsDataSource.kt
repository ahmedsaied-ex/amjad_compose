package com.example.amjadcomposeapp.data.local.dataSource

import com.example.amjadcomposeapp.domain.models.NewsModel

interface NewsDataSource {
    suspend fun getNews(): List<NewsModel>
}