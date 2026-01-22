package com.example.core.domain.usecase

import com.example.core.domain.model.UserProfile
import com.example.core.domain.repository.UserProfileRepository

class GetUserProfilesUseCase(private val repository: UserProfileRepository) {
    suspend operator fun invoke(): List<UserProfile> {
        return repository.getUserProfiles()
    }
}
