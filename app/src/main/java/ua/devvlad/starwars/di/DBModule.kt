package ua.devvlad.starwars.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ua.devvlad.starwars.db.StarWarsDataBase
import ua.devvlad.starwars.favorite.data.local.StarWarsDAO

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Provides
    fun provideDataBase(@ApplicationContext context: Context): StarWarsDataBase {
        return Room.databaseBuilder(
            context,
            StarWarsDataBase::class.java, "starWars-database"
        ).build()
    }

    @Provides
    fun provideStarWarsDAO(starWarsDataBase: StarWarsDataBase): StarWarsDAO {
        return requireNotNull(starWarsDataBase.getStarWarsDao())
    }
}