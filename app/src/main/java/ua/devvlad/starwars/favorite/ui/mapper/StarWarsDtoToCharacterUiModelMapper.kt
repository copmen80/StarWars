package ua.devvlad.starwars.favorite.ui.mapper

import ua.devvlad.starwars.favorite.data.local.dto.StarWarsDto
import ua.devvlad.starwars.search.ui.model.CharacterUIModel
import javax.inject.Inject

class StarWarsDtoToCharacterUiModelMapper @Inject constructor() {
    fun map(starWarsDto: StarWarsDto): CharacterUIModel {
        return CharacterUIModel(
            name = starWarsDto.name,
            starWarsDto = starWarsDto
        )
    }
}