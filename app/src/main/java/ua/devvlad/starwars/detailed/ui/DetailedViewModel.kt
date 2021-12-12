package ua.devvlad.starwars.detailed.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ua.devvlad.starwars.detailed.domain.IsInFavoriteUseCase
import ua.devvlad.starwars.detailed.ui.mapper.StarWarsDtoToDetailedCharacterUiModelMapper
import ua.devvlad.starwars.favorite.data.local.dto.StarWarsDto
import ua.devvlad.starwars.favorite.domain.DeleteFavoriteUseCase
import ua.devvlad.starwars.search.domain.AddToFavoriteUseCase
import ua.devvlad.starwars.search.ui.model.DetailedCharacterUIModel
import javax.inject.Inject

@HiltViewModel
class DetailedViewModel @Inject constructor(
    application: Application,
    private val deleteFavoriteUseCase: DeleteFavoriteUseCase,
    private val addToFavoriteUseCase: AddToFavoriteUseCase,
    private val isInFavoriteUseCase: IsInFavoriteUseCase,
    private val starWarsDtoToDetailedCharacterUiModelMapper: StarWarsDtoToDetailedCharacterUiModelMapper,
) : AndroidViewModel(application) {
    private lateinit var starWarsDto: StarWarsDto

    fun map(starWarsDto: StarWarsDto): DetailedCharacterUIModel {
        this.starWarsDto = starWarsDto
        return starWarsDtoToDetailedCharacterUiModelMapper.map(starWarsDto)
    }

    fun changeFavorite(name: String) {
        viewModelScope.launch {
            if (isInFavoriteUseCase(name))
                deleteFavoriteUseCase.invoke(starWarsDto)
            else
                addToFavoriteUseCase.invoke(starWarsDto)
        }
    }
}