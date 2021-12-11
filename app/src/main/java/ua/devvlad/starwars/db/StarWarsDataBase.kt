package ua.devvlad.starwars.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ua.devvlad.starwars.favorite.data.local.StarWarsDAO
import ua.devvlad.starwars.favorite.data.local.dto.StarWarsDto


@Database(entities = [StarWarsDto::class], version = 1)
abstract class StarWarsDataBase : RoomDatabase() {
    abstract fun getStarWarsDao(): StarWarsDAO?
}