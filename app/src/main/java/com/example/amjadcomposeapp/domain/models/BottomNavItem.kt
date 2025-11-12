package com.example.amjadcomposeapp.domain.models

data class BottomNavItem(
    val title: String,
    val selectedIcon: Int,
    val unSelectedIcon: Int,
    val route: Any
)
