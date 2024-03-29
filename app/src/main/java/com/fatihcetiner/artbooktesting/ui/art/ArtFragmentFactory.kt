package com.fatihcetiner.artbooktesting.ui.art

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.RequestManager
import com.fatihcetiner.artbooktesting.ui.art.adapter.ArtRecyclerAdapter
import com.fatihcetiner.artbooktesting.ui.imagelist.adapter.ImageRecyclerAdapter
import com.fatihcetiner.artbooktesting.ui.artDetail.ArtDetailsFragment
import com.fatihcetiner.artbooktesting.ui.imagelist.ImageApiFragment
import javax.inject.Inject

class ArtFragmentFactory @Inject constructor(
    private val artRecyclerAdapter: ArtRecyclerAdapter,
    private val glide : RequestManager,
    private val imageRecyclerAdapter: ImageRecyclerAdapter
):FragmentFactory(){

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {

        return when(className){
            ArtFragment::class.java.name -> ArtFragment(artRecyclerAdapter)
            ArtDetailsFragment::class.java.name -> ArtDetailsFragment(glide)
            ImageApiFragment::class.java.name -> ImageApiFragment(imageRecyclerAdapter)
            else -> super.instantiate(classLoader, className)
        }

    }
}