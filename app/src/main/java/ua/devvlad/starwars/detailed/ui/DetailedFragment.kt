package ua.devvlad.starwars.detailed.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ua.devvlad.starwars.databinding.DetailedCharacterFragmentBinding
import ua.devvlad.starwars.detailed.ui.adapter.DetailedAdapter
import ua.devvlad.starwars.favorite.data.local.dto.StarWarsDto
import ua.devvlad.starwars.search.ui.model.DetailedCharacterUIModel

@AndroidEntryPoint
class DetailedFragment : Fragment() {
    private var _binding: DetailedCharacterFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: DetailedViewModel

    private val filmsAdapter = DetailedAdapter()
    private val speciesAdapter = DetailedAdapter()
    private val vehiclesAdapter = DetailedAdapter()
    private val starshipsAdapter = DetailedAdapter()


    private val starWarsDto: StarWarsDto by lazy {
        requireNotNull(
            arguments?.getParcelable(DETAILED_CHARACTER)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[DetailedViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DetailedCharacterFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi(viewModel.map(starWarsDto))
    }

    private fun initUi(detailedCharacterUIModel: DetailedCharacterUIModel) {
        with(binding) {
            addOrRemoveFav.setOnClickListener {
                viewModel.changeFavorite(detailedCharacterUIModel.name)
            }
            val name = "Name: ${detailedCharacterUIModel.name}"
            tvName.text = name
            val height = "Height: ${detailedCharacterUIModel.height}"
            tvHeight.text = height
            val mass = "Mass: ${detailedCharacterUIModel.mass}"
            tvMass.text = mass
            val hairColor = "Hair Color: ${detailedCharacterUIModel.hairColor}"
            tvHairColor.text = hairColor
            val eyeColor = "Eye Color: ${detailedCharacterUIModel.eyeColor}"
            tvEyeColor.text = eyeColor
            val skinColor = "Skin Color: ${detailedCharacterUIModel.skinColor}"
            tvSkinColor.text = skinColor
            val birthYear = "Birth Year: ${detailedCharacterUIModel.birthYear}"
            tvBirthYear.text = birthYear
            val gender = "Gender: ${detailedCharacterUIModel.gender}"
            tvGender.text = gender
            val homeWorld = "Home World: ${detailedCharacterUIModel.homeworld}"
            tvHomeWorld.text = homeWorld
            rvFilms.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = filmsAdapter
                itemAnimator = null
            }
            rvSpecies.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = speciesAdapter
                itemAnimator = null
            }
            rvVehicles.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = vehiclesAdapter
                itemAnimator = null
            }
            rvStarships.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = starshipsAdapter
                itemAnimator = null
            }
            val created = "Created: ${detailedCharacterUIModel.created}"
            tvCreated.text = created
            val edited = "Edited: ${detailedCharacterUIModel.edited}"
            tvEdited.text = edited
            val url = "Url: ${detailedCharacterUIModel.url}"
            tvUrl.text = url
        }
        filmsAdapter.submitList(detailedCharacterUIModel.films)
        speciesAdapter.submitList(detailedCharacterUIModel.species)
        vehiclesAdapter.submitList(detailedCharacterUIModel.vehicles)
        starshipsAdapter.submitList(detailedCharacterUIModel.starships)
    }


    companion object {
        private const val DETAILED_CHARACTER = "detailed_character"
    }
}