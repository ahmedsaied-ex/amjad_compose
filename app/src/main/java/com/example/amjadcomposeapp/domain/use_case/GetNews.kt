package com.example.amjadcomposeapp.domain.use_case

import com.example.amjadcomposeapp.domain.models.NewsModel
import com.example.amjadcomposeapp.domain.repository.MainScreenRepository
import javax.inject.Inject

class GetNews @Inject constructor(private val repository: MainScreenRepository) {
    suspend operator fun invoke(): List<NewsModel> {
        return repository.getNews()
    }
}