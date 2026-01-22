package com.apiconnect.core.domain.repository

import com.apiconnect.core.domain.model.UserProfile

interface UserProfileRepository {
    suspend fun getUserProfiles(): List<UserProfile>
}
