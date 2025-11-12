package com.example.amjadcomposeapp.data.local.dataSource

import com.example.amjadcomposeapp.data.dummy.DummyData
import com.example.amjadcomposeapp.domain.models.NewsModel
import javax.inject.Inject

class NewsDataSourceImp @Inject constructor():NewsDataSource {
    override suspend fun getNews(): List<NewsModel> {
        return DummyData.newsList
    }
}