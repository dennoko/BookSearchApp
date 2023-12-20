package com.example.bookmanagemant.nerwork

import kotlinx.serialization.Serializable

@Serializable
data class BooksInfoDataModel(
    val kind: String,
    val totalItems: Int,
    val items: List<BookItem>,
)

@Serializable
data class BookItem(
    val kind: String,
    val id: String,
    val volumeInfo: VolumeInfo,
)

@Serializable
data class VolumeInfo(
    val title: String,
    val subtitle: String,
    val authors: List<String>,
    val publisher: String,
    val description: String,
    val imageLinks: ImageLink,
)

@Serializable
data class ImageLink(
    val smallThumbnail: String,
    val thumbnail: String,
)