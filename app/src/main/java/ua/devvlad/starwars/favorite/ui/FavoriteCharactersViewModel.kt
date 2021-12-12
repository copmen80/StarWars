package ua.devvlad.starwars.favorite.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import ua.devvlad.starwars.favorite.data.local.dto.StarWarsDto
import ua.devvlad.starwars.favorite.domain.DeleteFavoriteUseCase
import ua.devvlad.starwars.favorite.domain.GetFavoritesUseCase
import ua.devvlad.starwars.favorite.domain.SubscribeFavoritesUseCase
import ua.devvlad.starwars.favorite.ui.mapper.StarWarsDtoToCharacterUiModelMapper
import javax.inject.Inject


@HiltViewModel
class FavoriteCharactersViewModel @Inject constructor(
    application: Application,
    private val subscribeFavoritesUseCase: SubscribeFavoritesUseCase,
    private val deleteFavoriteUseCase: DeleteFavoriteUseCase,
    private val starWarsDtoToCharacterUiModelMapper: StarWarsDtoToCharacterUiModelMapper,
    private val getFavoritesUseCase: GetFavoritesUseCase
) : AndroidViewModel(application) {

    private val _content = MutableStateFlow<List<StarWarsDto>>(emptyList())
    val content = _content.asStateFlow()
        .map { list ->
            list.map { starWarsDtoToCharacterUiModelMapper.map(it) }
        }

    init {
        viewModelScope.launch {
            subscribeFavoritesUseCase()
                .collect {
                    _content.emit(it)
                }
        }
    }

    fun getFavorite(){
        viewModelScope.launch {
            _content.emit(getFavoritesUseCase.invoke())
        }
    }

    fun deleteFromFavorite(name: String) {
        viewModelScope.launch {
            val dtoToRemove = _content.value.find { it.name == name }
            if (dtoToRemove != null) deleteFavoriteUseCase(dtoToRemove)
            _content.emit(getFavoritesUseCase.invoke())
        }
    }
}