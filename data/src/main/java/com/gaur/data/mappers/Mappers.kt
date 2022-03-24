package com.gaur.data.mappers

import com.gaur.data.network.model.BlogDTO
import com.gaur.data.network.model.OwnerDTO
import com.gaur.domain.model.Blog
import com.gaur.domain.model.Owner


fun List<BlogDTO>.toDomain(): List<Blog> {

    return map {
        Blog(
            id = it.id ?: "",
            image = it.image ?: "",
            likes = it.likes ?: 0,
            owner = it.owner?.toDomain() ?: Owner("", "", "", "", ""),
            publishDate = it.publishDate ?: "",
            tags = it.tags ?: emptyList(),
            text = it.text ?: ""

        )
    }

}


fun OwnerDTO.toDomain(): Owner {
    return Owner(
        firstName = firstName ?: "",
        id = id ?: "",
        lastName = lastName ?: "",
        picture = picture ?: "",
        title = title ?: ""
    )
}
