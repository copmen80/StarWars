package ua.devvlad.starwars.favorite.ui.mapper

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ua.devvlad.starwars.favorite.data.local.dto.StarWarsDto
import ua.devvlad.starwars.search.ui.model.CharacterUIModel
import ua.devvlad.starwars.search.ui.model.DetailedCharacterUIModel
import javax.inject.Inject

class StarWarsDtoToUiModelMapper @Inject constructor() {
    fun map(starWarsDto: StarWarsDto): CharacterUIModel {
        val gson = Gson()
        return CharacterUIModel(
            name = starWarsDto.name,
            detailedCharacterUIModel = DetailedCharacterUIModel(
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
        )
    }

    private inline fun <reified T> Gson.fromJson(json: String) =
        fromJson<T>(json, object : TypeToken<T>() {}.type)
}