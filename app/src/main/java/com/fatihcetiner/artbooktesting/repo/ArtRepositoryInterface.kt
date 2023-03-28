package com.fatihcetiner.artbooktesting.repo

import androidx.lifecycle.LiveData
import com.fatihcetiner.artbooktesting.model.ImageResponse
import com.fatihcetiner.artbooktesting.roomdb.Art
import com.fatihcetiner.artbooktesting.util.Resource

interface ArtRepositoryInterface {

    suspend fun insertArt(art: Art)

    suspend fun deleteArt(art: Art)

    fun getArt(): LiveData<List<Art>>

    suspend fun searchImage(imageString : String): Resource<ImageResponse>
}