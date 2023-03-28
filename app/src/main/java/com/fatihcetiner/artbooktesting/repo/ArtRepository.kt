package com.fatihcetiner.artbooktesting.repo

import androidx.lifecycle.LiveData
import com.fatihcetiner.artbooktesting.api.RetrofitAPI
import com.fatihcetiner.artbooktesting.model.ImageResponse
import com.fatihcetiner.artbooktesting.roomdb.Art
import com.fatihcetiner.artbooktesting.roomdb.ArtDao
import com.fatihcetiner.artbooktesting.util.Resource
import javax.inject.Inject

class ArtRepository @Inject constructor(
    private val artDao: ArtDao,
    private val retrofitAPI: RetrofitAPI
    ) : ArtRepositoryInterface{

    override suspend fun insertArt(art: Art) {
        artDao.insertArt(art)
    }

    override suspend fun deleteArt(art: Art) {
        artDao.deleteArt(art)
    }

    override fun getArt(): LiveData<List<Art>> {
        return artDao.observeArt()
    }

    override suspend fun searchImage(imageString: String): Resource<ImageResponse> {
        return try {
            val response = retrofitAPI.imageSearch(imageString)
            if (response.isSuccessful){
                response.body()?.let {
                    return@let Resource.success(it)
                }?: Resource.error("Error",null)
            }else{
                Resource.error("Error",null)
            }
        }catch (e: Exception){
            Resource.error("No Data !",null)
        }
    }
}