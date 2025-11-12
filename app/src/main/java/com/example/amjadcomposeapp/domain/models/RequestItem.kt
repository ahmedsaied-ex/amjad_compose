package com.example.amjadcomposeapp.domain.models
import kotlinx.serialization.Serializable

@Serializable
enum class RequestStatus { ACCEPTED, REJECTED, PENDING }
@Serializable
data class RequestItem(
    val id: String,
    val name: String,
    val title: String,
    val description: String,
    val status: RequestStatus
)
