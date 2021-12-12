package ua.devvlad.starwars.detailed.ui.mapper

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ua.devvlad.starwars.favorite.data.local.dto.StarWarsDto
import ua.devvlad.starwars.search.ui.model.DetailedCharacterUIModel
import javax.inject.Inject

class StarWarsDtoToDetailedCharacterUiModelMapper @Inject constructor() {
    fun map(starWarsDto: StarWarsDto): DetailedCharacterUIModel {
        val gson = Gson()
        return DetailedCharacterUIModel(
            starWarsDto.name,
            starWarsDto.height,
            starWarsDto.mass,
            starWarsDto.hairColor,
            starWarsDto.skinColor,
            starWarsDto.eyeColor,
            starWarsDto.birthYear,
            starWarsDto.gender,
            starWarsDto.homeworld,
            gson.fromJson(starWarsDto.filmsJson),
            gson.fromJson(starWarsDto.speciesJson),
            gson.fromJson(starWarsDto.vehiclesJson),
            gson.fromJson(starWarsDto.starshipsJson),
            starWarsDto.created,
            starWarsDto.edited,
            starWarsDto.url
        )
    }

    private inline fun <reified T> Gson.fromJson(json: String) =
        fromJson<T>(json, object : TypeToken<T>() {}.type)

}