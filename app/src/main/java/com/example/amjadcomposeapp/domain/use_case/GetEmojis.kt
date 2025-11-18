package com.example.amjadcomposeapp.domain.use_case

import com.example.amjadcomposeapp.domain.models.BottomBarEmojis
import com.example.amjadcomposeapp.domain.repository.MainScreenRepository
import javax.inject.Inject

class GetEmojis @Inject constructor(private val repository: MainScreenRepository) {
    suspend operator fun invoke(): List<BottomBarEmojis> {
        return repository.getBottomBarEmojis()
    }
}