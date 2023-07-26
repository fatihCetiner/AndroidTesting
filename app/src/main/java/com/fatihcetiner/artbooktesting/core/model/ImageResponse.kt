package com.fatihcetiner.artbooktesting.core.model

import com.fatihcetiner.artbooktesting.core.model.ImageResult

data class ImageResponse(
    val hits: List<ImageResult>,
    val total: Int,
    val totalHits: Int
)
