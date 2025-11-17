package com.example.amjadcomposeapp.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class AppRoute {
    // BottomNav screens
    @Serializable object Home : AppRoute()
    @Serializable object Offers : AppRoute()
    @Serializable object Vendors : AppRoute()
    @Serializable object News : AppRoute()
    @Serializable object MyConsultant : AppRoute()
    @Serializable object ProfileDetails : AppRoute()
    @Serializable object Requests : AppRoute()
    @Serializable object RequestDetails : AppRoute()
    @Serializable object Library : AppRoute()
    @Serializable object LibraryContent : AppRoute()
    @Serializable object Calendar : AppRoute()
    @Serializable object Attachment : AppRoute()
}
