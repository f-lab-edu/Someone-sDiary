package com.kova700.someonesdiary.view.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.kova700.someonesdiary.data.DiaryListItem
import com.kova700.someonesdiary.R
import com.kova700.someonesdiary.databinding.ItemDiaryBinding
import javax.inject.Inject

class DiaryListAdapter @Inject constructor() :
    ListAdapter<DiaryListItem, DiaryListViewHolder>(DiaryListItemDiffUtil()) {
    var onItemClick: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiaryListViewHolder {
        val binding =
            ItemDiaryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DiaryListViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: DiaryListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int = R.layout.item_diary
}