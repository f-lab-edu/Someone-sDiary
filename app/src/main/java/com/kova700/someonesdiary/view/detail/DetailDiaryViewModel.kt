package com.kova700.someonesdiary.view.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.kova700.someonesdiary.data.DiaryListItem
import com.kova700.someonesdiary.view.main.MainActivity.Companion.TO_DETAIL_SELECTED_ITEM_EXTRA
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailDiaryViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val selectedItem: DiaryListItem =
        savedStateHandle.get<DiaryListItem>(TO_DETAIL_SELECTED_ITEM_EXTRA)!!
}