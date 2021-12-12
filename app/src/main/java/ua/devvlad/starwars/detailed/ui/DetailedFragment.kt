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

    private val adapter = DetailedAdapter()

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
            tvName.text = detailedCharacterUIModel.name
            tvHeight.text = detailedCharacterUIModel.height
            tvMass.text = detailedCharacterUIModel.name
            tvHairColor.text = detailedCharacterUIModel.name
            tvEyeColor.text = detailedCharacterUIModel.name
            tvSkinColor.text = detailedCharacterUIModel.name
            tvBirthYear.text = detailedCharacterUIModel.name
            tvGender.text = detailedCharacterUIModel.name
            tvHomeWorld.text = detailedCharacterUIModel.name
            rvFilms.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = this@DetailedFragment.adapter
                itemAnimator = null
            }
            rvSpecies.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = this@DetailedFragment.adapter
                itemAnimator = null
            }
            rvVehicles.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = this@DetailedFragment.adapter
                itemAnimator = null
            }
            rvStarships.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = this@DetailedFragment.adapter
                itemAnimator = null
            }
            tvCreated.text = detailedCharacterUIModel.name
            tvEdited.text = detailedCharacterUIModel.name
            tvUrl.text = detailedCharacterUIModel.name
        }
    }


    companion object {
        private const val DETAILED_CHARACTER = "detailed_character"
    }
}