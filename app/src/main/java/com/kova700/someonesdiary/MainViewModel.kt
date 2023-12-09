package com.kova700.someonesdiary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _eventFlow = MutableSharedFlow<MainUiEvent>()
    val eventFlow: SharedFlow<MainUiEvent>
        get() = _eventFlow

    private var _isLoading = MutableStateFlow(false)
    val isLoading: SharedFlow<Boolean>
        get() = _isLoading

    val diaryListFlow = MutableStateFlow(getDummyList())

    fun itemClickListener(selectedItem: DiaryListItem) = viewModelScope.launch {
        startEvent(MoveToDetail(selectedItem))
    }

    private suspend fun startEvent(event: MainUiEvent) {
        _eventFlow.emit(event)
    }

    sealed interface MainUiEvent
    data class MoveToDetail(val diaryListItem: DiaryListItem) : MainUiEvent
}