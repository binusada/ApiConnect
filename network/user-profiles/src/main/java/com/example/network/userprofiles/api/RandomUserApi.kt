package com.example.network.userprofiles.api

import com.example.network.userprofiles.dto.UserResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomUserApi {
    @GET("api/")
    suspend fun getUsers(@Query("results") results: Int = 50): UserResponseDto
}
