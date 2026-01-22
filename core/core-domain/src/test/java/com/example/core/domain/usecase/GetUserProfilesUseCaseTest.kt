package com.example.core.domain.usecase

import com.example.core.domain.model.UserProfile
import com.example.core.domain.repository.UserProfileRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class GetUserProfilesUseCaseTest {

    @Test
    fun `invoke returns list of user profiles from repository`() = runBlocking {
        // Arrange
        val expectedProfiles = listOf(
            UserProfile("1", "Mr", "John", "Doe", "john@example.com", "url")
        )
        val fakeRepository = object : UserProfileRepository {
            override suspend fun getUserProfiles(): List<UserProfile> {
                return expectedProfiles
            }
        }
        val useCase = GetUserProfilesUseCase(fakeRepository)

        // Act
        val result = useCase()

        // Assert
        assertEquals(expectedProfiles, result)
    }
}
