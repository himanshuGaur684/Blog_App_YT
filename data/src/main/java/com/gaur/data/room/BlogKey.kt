package com.gaur.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BlogKey(
    @PrimaryKey(autoGenerate = false)
    var id: Int,
    var prev: Int?,
    var next: Int?
)
