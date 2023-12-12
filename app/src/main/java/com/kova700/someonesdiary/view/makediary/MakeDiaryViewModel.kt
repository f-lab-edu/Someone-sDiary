package com.kova700.someonesdiary.view.makediary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kova700.someonesdiary.data.source.unsplash.UnsplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MakeDiaryViewModel @Inject constructor(
    private val unsplashRepository: UnsplashRepository
) : ViewModel() {

    val currentQuery = MutableStateFlow("")
    private val currentPageFlow: MutableStateFlow<Int> = MutableStateFlow(1)

    val photoListFlow = currentQuery
        .flatMapLatest { query ->
            unsplashRepository.getPhotoList(
                query = query
            )
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = listOf()
        )
}