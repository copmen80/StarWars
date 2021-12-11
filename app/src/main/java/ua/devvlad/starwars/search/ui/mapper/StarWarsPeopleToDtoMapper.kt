package ua.devvlad.starwars.search.ui.mapper

import com.google.gson.Gson
import ua.devvlad.starwars.favorite.data.local.dto.StarWarsDto
import ua.devvlad.starwars.search.data.response.People
import javax.inject.Inject

class StarWarsPeopleToDtoMapper @Inject constructor() {
    fun map(people: People): StarWarsDto {
        val gson = Gson()
        return StarWarsDto(
            name = people.name,
            height = people.height,
            mass = people.mass,
            hairColor = people.hairColor,
            skinColor = people.skinColor,
            eyeColor = people.eyeColor,
            birthYear = people.birthYear,
            gender = people.gender,
            homeworld = people.homeworld,
            filmsJson = gson.toJson(people.films),
            speciesJson = gson.toJson(people.species),
            vehiclesJson = gson.toJson(people.vehicles),
            starshipsJson = gson.toJson(people.starships),
            created = people.created,
            edited = people.edited,
            url = people.url
        )
    }
}