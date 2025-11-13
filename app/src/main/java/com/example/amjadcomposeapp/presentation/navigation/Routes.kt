package com.example.amjadcomposeapp.presentation.navigation

import com.example.amjadcomposeapp.domain.models.RequestItem
import kotlinx.serialization.Serializable

@Serializable
sealed class AppRoute {
    // BottomNav screens
    @Serializable object Home : AppRoute()
    @Serializable object Offers : AppRoute()
    @Serializable object Vendors : AppRoute()
    @Serializable object News : AppRoute()
    @Serializable object MyConsultant : AppRoute()

    // Secondary
    @Serializable object ProfileDetails : AppRoute()

    // Requests
    @Serializable object Requests : AppRoute()
    @Serializable object RequestDetails : AppRoute()

    // Library
    @Serializable object Library : AppRoute()
    @Serializable object LibraryContent : AppRoute()
    @Serializable object Calendar : AppRoute()
    @Serializable object Attachment : AppRoute()
}
