package com.example.amjadcomposeapp.presentation.components.requestScreenComponents

import androidx.compose.runtime.Composable
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.RequestStatus

data class StatusUI(
    val backgroundColor: Int,
    val borderColor: Int,
    val text: Int,
    val textColor: Int
)
data class SmallBanner(
    val backgroundColor: Int,
    val borderColor: Int,
    val text: Int,
    val textColor: Int,
    val icon: Int
)

@Composable
fun RequestStatus.toMainBannerUI(): StatusUI = when (this) {
    RequestStatus.ACCEPTED -> StatusUI(
        R.color.background_accepted_request,
        R.color.border_accepted_request,
        R.string.accepted_request,
        R.color.accepted_text_color
    )
    RequestStatus.REJECTED -> StatusUI(
        R.color.background_rejected_request,
        R.color.border_rejected_request,
        R.string.rejected_request,
        R.color.rejected_text_color
    )
    RequestStatus.PENDING -> StatusUI(
        R.color.background_waiting_request,
        R.color.border_waiting_request,
        R.string.waiting_request,
        R.color.waiting_text_color
    )
}
@Composable
fun RequestStatus.toSmallBannerUI(): SmallBanner = when (this) {
    RequestStatus.ACCEPTED -> SmallBanner(
        R.color.background_accepted_request,
        R.color.border_accepted_request,
        R.string.accepted_request,
        R.color.accepted_text_color,
        R.drawable.ic_agreed
    )
    RequestStatus.REJECTED -> SmallBanner(
        R.color.background_rejected_request,
        R.color.border_rejected_request,
        R.string.rejected_request,
        R.color.rejected_text_color,
        R.drawable.cancelled_session_ic
    )
    RequestStatus.PENDING -> SmallBanner(
        R.color.background_waiting_request,
        R.color.border_waiting_request,
        R.string.waiting_request,
        R.color.waiting_text_color,
        R.drawable.ic_pending
    )
}

