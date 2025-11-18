package com.example.amjadcomposeapp.presentation.components.requestScreenComponents

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.amjadcomposeapp.R
import com.example.amjadcomposeapp.domain.models.RequestStatus
import com.example.amjadcomposeapp.ui.theme.BackgroundAcceptedRequest
import com.example.amjadcomposeapp.ui.theme.BackgroundRejectedRequest
import com.example.amjadcomposeapp.ui.theme.BackgroundWaitingRequest
import com.example.amjadcomposeapp.ui.theme.BorderAcceptedRequest
import com.example.amjadcomposeapp.ui.theme.BorderRejectedRequest
import com.example.amjadcomposeapp.ui.theme.BorderWaitingRequest
import com.example.amjadcomposeapp.ui.theme.CalendarItemSelectedBackground
import com.example.amjadcomposeapp.ui.theme.CalenderGreenText
import com.example.amjadcomposeapp.ui.theme.ResignationButtonColor

data class SmallBanner(
    val backgroundColor: Color,
    val borderColor: Color,
    val text: Int,
    val textColor: Color,
    val icon: Int
)

@Composable
fun RequestStatus.toSmallBannerUI(): SmallBanner = when (this) {
    RequestStatus.ACCEPTED -> SmallBanner(
        BackgroundAcceptedRequest,
        BorderAcceptedRequest,
        R.string.accepted_request_agreed_on,
        CalenderGreenText,
        R.drawable.ic_agreed,

    )
    RequestStatus.REJECTED -> SmallBanner(
        BackgroundRejectedRequest,
        BorderRejectedRequest,
        R.string.rejected_request,
        ResignationButtonColor,
        R.drawable.cancelled_session_ic
    )
    RequestStatus.PENDING -> SmallBanner(
        BackgroundWaitingRequest,
        BorderWaitingRequest,
        R.string.waiting_request,
        CalendarItemSelectedBackground,
        R.drawable.ic_pending
    )
}

