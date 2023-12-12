package com.kova700.someonesdiary.view.makediary.imagesearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.kova700.someonesdiary.databinding.FragmentImageSearchBinding
import com.kova700.someonesdiary.view.makediary.MakeDiaryViewModel
import com.kova700.someonesdiary.view.makediary.imagesearch.adapter.ImageSearchListAdpater
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ImageSearchFragment : Fragment() {
    private var _binding: FragmentImageSearchBinding? = null
    private val binding get() = _binding!!

    private val makeDiaryViewModel by activityViewModels<MakeDiaryViewModel>()

    @Inject
    lateinit var imageSearchListAdpater: ImageSearchListAdpater

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentImageSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSearchView()
        initAdapter()
        initRecyclerView()
        observePhotoListFlow()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observePhotoListFlow() = lifecycleScope.launch {
        makeDiaryViewModel.photoListFlow.collect { photoList ->
            imageSearchListAdpater.submitList(photoList)
        }
    }

    private fun initSearchView() {
        binding.svImageSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { makeDiaryViewModel.currentQuery.update { it } }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    private fun initAdapter() {
        imageSearchListAdpater.apply {
            onItemClick = { itemPosition ->
//                makeDiaryViewModel.itemClickListener(imageSearchListAdpater.currentList[itemPosition])
            }
        }
    }

    private fun initRecyclerView() {
        val gridLayoutManager =
            StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)

        binding.rcvImageSearch.apply {
            adapter = imageSearchListAdpater
            layoutManager = gridLayoutManager
        }
    }
}