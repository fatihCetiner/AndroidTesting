package com.fatihcetiner.artbooktesting.data.repository

import androidx.lifecycle.LiveData
import com.fatihcetiner.artbooktesting.core.model.ImageResponse
import com.fatihcetiner.artbooktesting.core.model.Art
import com.fatihcetiner.artbooktesting.util.Resource

interface ArtRepositoryInterface {

    suspend fun insertArt(art: Art)

    suspend fun deleteArt(art: Art)

    fun getArt(): LiveData<List<Art>>

    suspend fun searchImage(imageString : String): Resource<ImageResponse>
}