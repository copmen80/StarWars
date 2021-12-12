package ua.devvlad.starwars.search.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import ua.devvlad.starwars.favorite.data.local.dto.StarWarsDto
import ua.devvlad.starwars.favorite.ui.mapper.StarWarsDtoToCharacterUiModelMapper
import ua.devvlad.starwars.search.domain.AddToFavoriteUseCase
import ua.devvlad.starwars.search.domain.GetAllCharactersUseCase
import javax.inject.Inject


@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    application: Application,
    private val getAllCharactersUseCase: GetAllCharactersUseCase,
    private val addToFavoriteUseCase: AddToFavoriteUseCase,
    private val starWarsDtoToCharacterUiModelMapper: StarWarsDtoToCharacterUiModelMapper,
) : AndroidViewModel(application) {

    private val _content = MutableStateFlow<List<StarWarsDto>>(emptyList())
    val content = _content
        .asStateFlow()
        .map { list ->
            list.map { starWarsDtoToCharacterUiModelMapper.map(it) }
        }

    init {
        viewModelScope.launch {
            try {
                _content.emit(getAllCharactersUseCase())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun addToFavorite(name: String) {
        viewModelScope.launch {
            val dtoToFav = _content.value.find { it.name == name }
            if (dtoToFav != null) addToFavoriteUseCase(dtoToFav)
        }
    }
}