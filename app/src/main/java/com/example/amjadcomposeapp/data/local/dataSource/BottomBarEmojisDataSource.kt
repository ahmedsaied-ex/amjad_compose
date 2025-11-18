package com.example.amjadcomposeapp.data.local.dataSource

import com.example.amjadcomposeapp.domain.models.BottomBarEmojis

interface BottomBarEmojisDataSource {

    suspend fun getBottomBarEmojis(): List<BottomBarEmojis>
}