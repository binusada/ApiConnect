package com.apiconnect.core.domain.model

data class UserProfile(
    val id: String, // using email or uuid as id
    val title: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val pictureUrl: String
)
