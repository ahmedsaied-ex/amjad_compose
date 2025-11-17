package com.example.amjadcomposeapp.presentation.components.requestScreenComponents

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.media3.common.C
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.RequestStatus
import com.example.amjadcomposeapp.ui.theme.AcceptedTextColor
import com.example.amjadcomposeapp.ui.theme.BackgroundAcceptedRequest
import com.example.amjadcomposeapp.ui.theme.BackgroundRejectedRequest
import com.example.amjadcomposeapp.ui.theme.BackgroundWaitingRequest
import com.example.amjadcomposeapp.ui.theme.BorderAcceptedRequest
import com.example.amjadcomposeapp.ui.theme.BorderRejectedRequest
import com.example.amjadcomposeapp.ui.theme.BorderWaitingRequest
import com.example.amjadcomposeapp.ui.theme.RejectedTextColor
import com.example.amjadcomposeapp.ui.theme.WaitingTextColor

data class StatusUI(
    val backgroundColor: Color,
    val borderColor: Color,
    val text: Int,
    val textColor: Color
)
data class SmallBanner(
    val backgroundColor: Color,
    val borderColor: Color,
    val text: Int,
    val textColor: Color,
    val icon: Int
)

@Composable
fun RequestStatus.toMainBannerUI(): StatusUI = when (this) {
    RequestStatus.ACCEPTED -> StatusUI(
        BackgroundAcceptedRequest,
        BorderAcceptedRequest,
        R.string.accepted,
        AcceptedTextColor
    )
    RequestStatus.REJECTED -> StatusUI(
        BackgroundRejectedRequest,
        BorderRejectedRequest,
        R.string.rejected_request,
        RejectedTextColor
    )
    RequestStatus.PENDING -> StatusUI(
        BackgroundWaitingRequest,
        BorderWaitingRequest,
        R.string.waiting_request,
        WaitingTextColor
    )
}
@Composable
fun RequestStatus.toSmallBannerUI(): SmallBanner = when (this) {
    RequestStatus.ACCEPTED -> SmallBanner(
        BackgroundAcceptedRequest,
        BorderAcceptedRequest,
        R.string.accepted_request,
        AcceptedTextColor,
        R.drawable.ic_agreed
    )
    RequestStatus.REJECTED -> SmallBanner(
        BackgroundRejectedRequest,
        BorderRejectedRequest,
        R.string.rejected_request,
        RejectedTextColor,
        R.drawable.cancelled_session_ic
    )
    RequestStatus.PENDING -> SmallBanner(
        BackgroundWaitingRequest,
        BorderWaitingRequest,
        R.string.waiting_request,
        WaitingTextColor,
        R.drawable.ic_pending
    )
}

