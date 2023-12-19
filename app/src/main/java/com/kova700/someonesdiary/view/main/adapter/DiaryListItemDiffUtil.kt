package com.kova700.someonesdiary.view.main.adapter

import androidx.recyclerview.widget.DiffUtil
import com.kova700.someonesdiary.data.DiaryListItem

class DiaryListItemDiffUtil : DiffUtil.ItemCallback<DiaryListItem>() {
    override fun areItemsTheSame(oldItem: DiaryListItem, newItem: DiaryListItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DiaryListItem, newItem: DiaryListItem): Boolean {
        return oldItem == newItem
    }
}