package com.example.core.domain.repository

import com.example.core.domain.model.UserProfile

interface UserProfileRepository {
    suspend fun getUserProfiles(): List<UserProfile>
}
