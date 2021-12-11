package ua.devvlad.starwars.favorite.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ua.devvlad.starwars.favorite.data.local.dto.StarWarsDto

@Dao
interface StarWarsDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(starWarsDto: StarWarsDto)

    @Delete
    suspend fun delete(starWarsDto: StarWarsDto)

    @Query("SELECT * FROM character WHERE name LIKE :name")
    suspend fun getCharacterByName(name: String?): StarWarsDto?

    @Query("SELECT * FROM character")
    fun getCharactersFlow(): Flow<List<StarWarsDto>>

    @Query("SELECT * FROM character")
    suspend fun getCharacters(): List<StarWarsDto>
}