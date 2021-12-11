package ua.devvlad.starwars.search.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import ua.devvlad.starwars.databinding.SearchScreenFragmentBinding
import ua.devvlad.starwars.search.ui.adapter.SearchAdapter

@AndroidEntryPoint
class SearchScreenFragment : Fragment() {
    private var _binding: SearchScreenFragmentBinding? = null
    private val binding get() = _binding!!

    private val adapter = SearchAdapter { name ->
        viewModel.addToFavorite(name)
    }

    private lateinit var viewModel: SearchScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[SearchScreenViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SearchScreenFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecycler()
        handleViewModel()

    }

    private fun setupRecycler() {
        binding.rvSearch.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@SearchScreenFragment.adapter
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
}