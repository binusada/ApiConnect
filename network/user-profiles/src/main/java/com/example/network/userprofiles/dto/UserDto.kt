package com.example.network.userprofiles.dto

import com.google.gson.annotations.SerializedName

data class UserResponseDto(
    @SerializedName("results") val results: List<UserDto>
)

data class UserDto(
    @SerializedName("name") val name: NameDto,
    @SerializedName("email") val email: String,
    @SerializedName("picture") val picture: PictureDto
)

data class NameDto(
    @SerializedName("title") val title: String,
    @SerializedName("first") val first: String,
    @SerializedName("last") val last: String
)

data class PictureDto(
    @SerializedName("large") val large: String,
    @SerializedName("medium") val medium: String,
    @SerializedName("thumbnail") val thumbnail: String
)
