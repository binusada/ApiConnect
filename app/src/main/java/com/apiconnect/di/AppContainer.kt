package com.apiconnect.di

import com.apiconnect.core.domain.repository.UserProfileRepository
import com.apiconnect.core.domain.usecase.GetUserProfilesUseCase
import com.apiconnect.network.core.NetworkClient
import com.apiconnect.network.userprofiles.api.RandomUserApi
import com.apiconnect.network.userprofiles.repository.UserProfileRepositoryImpl

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
