package com.kova700.someonesdiary.view.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.kova700.someonesdiary.view.main.MainViewModel
import com.kova700.someonesdiary.view.main.MainViewModel.MainUiEvent
import com.kova700.someonesdiary.view.main.MainViewModel.MoveToDetail
import com.kova700.someonesdiary.databinding.FragmentHomeBinding
import com.kova700.someonesdiary.view.main.adapter.DiaryListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val mainViewModel by activityViewModels<MainViewModel>()

    @Inject
    lateinit var homeAdapter: DiaryListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeUiEvent()
        observeLoadingFlag()
        observeDiaryListFlow()
        initAdapter()
        initRecyclerView()
    }

    private fun observeUiEvent() = viewLifecycleOwner.lifecycleScope.launch {
        mainViewModel.eventFlow.collect { event ->
            handleUiEvent(event)
        }
    }

    private fun observeLoadingFlag() = viewLifecycleOwner.lifecycleScope.launch {
        mainViewModel.isLoading.collect { isLoading ->
            handleLoading(isLoading)
        }
    }

    private fun observeDiaryListFlow() = viewLifecycleOwner.lifecycleScope.launch {
        mainViewModel.diaryListFlow.collect { diaryList ->
            homeAdapter.submitList(diaryList)
        }
    }

    private fun initAdapter() {
        homeAdapter.apply {
            onItemClick = { itemPosition ->
                mainViewModel.itemClickListener(homeAdapter.currentList[itemPosition])
            }
        }
    }

    private fun initRecyclerView() {
        val gridLayoutManager =
            StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)

        binding.rcvHomeFragment.apply {
            adapter = homeAdapter
            layoutManager = gridLayoutManager
        }
    }

    private fun moveToDetail() {

    }

    private fun handleUiEvent(event: MainUiEvent) {
        when (event) {
            is MoveToDetail -> moveToDetail()
        }
    }

    private fun handleLoading(isLoading: Boolean) {
        _binding?.pbHomeFragment?.visibility =
            if (isLoading) View.VISIBLE else View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}