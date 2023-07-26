package com.fatihcetiner.artbooktesting.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fatihcetiner.artbooktesting.core.model.Art

@Database(entities = [Art::class], version = 1)
abstract class ArtDatabase : RoomDatabase(){
    abstract fun artDao(): ArtDao
}