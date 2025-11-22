package com.techevents.core.navigation

import kotlinx.serialization.Serializable

@Serializable
object CatalogScreen

@Serializable
data class DetailScreen(
    val title: String,
    val description: String,
    val image: Int
)
