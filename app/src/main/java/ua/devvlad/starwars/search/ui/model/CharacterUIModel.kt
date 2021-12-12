package ua.devvlad.starwars.search.ui.model

import ua.devvlad.starwars.favorite.data.local.dto.StarWarsDto

data class CharacterUIModel(
    val name: String,
    val starWarsDto: StarWarsDto
)