package com.alextroy.aam3alextroy.model

import java.util.*

object Data {
    data class NewsItem(val title: String,
                        val imageUrl: String,
                        val category: Category,
                        val publishDate: Date,
                        val previewText: String,
                        val fullText: String)

    data class Category(val id: Int, val name: String)
}