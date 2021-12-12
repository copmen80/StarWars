package ua.devvlad.starwars.favorite.data.local.dto

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "character")
data class StarWarsDto(
    @PrimaryKey
    val name: String,
    val height: String,
    val mass: String,
    val hairColor: String,
    val skinColor: String,
    val eyeColor: String,
    val birthYear: String,
    val gender: String,
    val homeworld: String,
    val filmsJson: String,
    val speciesJson: String,
    val vehiclesJson: String,
    val starshipsJson: String,
    val created: String,
    val edited: String,
    val url: String,
) : Parcelable