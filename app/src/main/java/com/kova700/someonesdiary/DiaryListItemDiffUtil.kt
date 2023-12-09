package com.kova700.someonesdiary

import androidx.recyclerview.widget.DiffUtil

class DiaryListItemDiffUtil : DiffUtil.ItemCallback<DiaryListItem>() {
    override fun areItemsTheSame(oldItem: DiaryListItem, newItem: DiaryListItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DiaryListItem, newItem: DiaryListItem): Boolean {
        return oldItem == newItem
    }
}