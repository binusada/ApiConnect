package com.example.network.userprofiles.repository

import com.example.core.domain.model.UserProfile
import com.example.core.domain.repository.UserProfileRepository
import com.example.network.userprofiles.api.RandomUserApi
import com.example.network.userprofiles.dto.UserDto

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
