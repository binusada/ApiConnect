package com.apiconnect.core.domain.usecase

import com.apiconnect.core.domain.model.UserProfile
import com.apiconnect.core.domain.repository.UserProfileRepository

class GetUserProfilesUseCase(private val repository: UserProfileRepository) {
    suspend operator fun invoke(): List<UserProfile> {
        return repository.getUserProfiles()
    }
}
