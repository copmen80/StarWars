package ua.devvlad.starwars.favorite.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import ua.devvlad.starwars.databinding.FavoriteCharactersFragmentBinding
import ua.devvlad.starwars.favorite.data.local.dto.StarWarsDto
import ua.devvlad.starwars.favorite.ui.adapter.FavoriteAdapter
import ua.devvlad.starwars.favorite.ui.adapter.OpenDetailed
import ua.devvlad.starwars.favorite.ui.adapter.RemoveFromFavorite

@AndroidEntryPoint
class FavoriteCharactersFragment : Fragment() {
    private var _binding: FavoriteCharactersFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: FavoriteCharactersViewModel

    private val adapter = FavoriteAdapter { event ->
        when (event) {
            is RemoveFromFavorite -> viewModel.deleteFromFavorite(event.name)
            is OpenDetailed -> navigateDetailedFragment(event.starWarsDto)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel =
            ViewModelProvider(requireActivity())[FavoriteCharactersViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FavoriteCharactersFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        handleViewModel()
    }

    private fun setupRecycler() {
        binding.rvFav.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@FavoriteCharactersFragment.adapter
            itemAnimator = null
        }
    }

    private fun handleViewModel() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.content.collectLatest { list ->
                adapter.submitList(list)
            }
        }
    }

    private fun navigateDetailedFragment(starWarsDto: StarWarsDto) {
        val action =
            FavoriteCharactersFragmentDirections.actionFavoriteCharactersFragmentToDetailedFragment(
                starWarsDto
            )
        findNavController().navigate(action)
    }
}