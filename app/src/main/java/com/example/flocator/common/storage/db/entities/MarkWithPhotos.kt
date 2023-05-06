package com.example.flocator.common.storage.db.entities

import androidx.room.Embedded
import androidx.room.Relation

data class MarkWithPhotos(
    @Embedded
    val mark: Mark,

    @Relation(parentColumn = "markId", entityColumn = "markId")
    val photos: List<MarkPhoto>
)
