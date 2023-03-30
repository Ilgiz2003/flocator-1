package com.example.flocator.main.models

import com.google.gson.annotations.SerializedName
import com.yandex.mapkit.geometry.Point

data class Mark(
    @SerializedName("markId")
    val markId: Long,
    @SerializedName("authorId")
    val authorId: Long,
    @SerializedName("point")
    val location: Point,
    @SerializedName("text")
    val text: String,
    @SerializedName("isPublic")
    val isPublic: Boolean,
    @SerializedName("photos")
    val photos: List<String>
)
