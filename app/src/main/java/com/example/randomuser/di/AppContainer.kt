package com.example.randomuser.di

import com.example.core.domain.repository.UserProfileRepository
import com.example.core.domain.usecase.GetUserProfilesUseCase
import com.example.network.core.NetworkClient
import com.example.network.userprofiles.api.RandomUserApi
import com.example.network.userprofiles.repository.UserProfileRepositoryImpl

class AppContainer {

    private val retrofit by lazy {
        NetworkClient.createRetrofit("https://randomuser.me/")
    }

    private val randomUserApi by lazy {
        retrofit.create(RandomUserApi::class.java)
    }

    private val userProfileRepository: UserProfileRepository by lazy {
        UserProfileRepositoryImpl(randomUserApi)
    }

    val getUserProfilesUseCase by lazy {
        GetUserProfilesUseCase(userProfileRepository)
    }
}
