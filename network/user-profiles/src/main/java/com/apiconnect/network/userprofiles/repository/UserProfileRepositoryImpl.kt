package com.apiconnect.network.userprofiles.repository

import com.apiconnect.core.domain.model.UserProfile
import com.apiconnect.core.domain.repository.UserProfileRepository
import com.apiconnect.network.userprofiles.api.RandomUserApi
import com.apiconnect.network.userprofiles.dto.UserDto

class UserProfileRepositoryImpl(
    private val api: RandomUserApi
) : UserProfileRepository {

    override suspend fun getUserProfiles(): List<UserProfile> {
        val response = api.getUsers()
        return response.results.map { it.toDomain() }
    }

    private fun UserDto.toDomain(): UserProfile {
        return UserProfile(
            id = this.email, // using email as unique identifier
            title = this.name.title,
            firstName = this.name.first,
            lastName = this.name.last,
            email = this.email,
            pictureUrl = this.picture.medium // Use medium for list
        )
    }
}
