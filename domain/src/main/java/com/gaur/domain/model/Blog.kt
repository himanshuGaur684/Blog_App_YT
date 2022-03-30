package com.gaur.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Blog(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val image: String,
    val likes: Int,
    val owner: Owner,
    val publishDate: String,
    val tags: List<String>,
    val text: String
)
