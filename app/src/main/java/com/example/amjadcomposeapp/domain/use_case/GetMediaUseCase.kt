package com.example.amjadcomposeapp.domain.use_case

import com.example.amjadcomposeapp.domain.models.MediaRequest
import com.example.amjadcomposeapp.domain.repository.MediaRepository
import javax.inject.Inject

class GetMediaUseCase @Inject constructor(private val repository: MediaRepository) {
    suspend operator fun invoke(): List<MediaRequest> {
        return repository.getMedia()
    }
}