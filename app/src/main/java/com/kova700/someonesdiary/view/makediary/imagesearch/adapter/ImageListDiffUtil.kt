package com.kova700.someonesdiary.view.makediary.imagesearch.adapter

import androidx.recyclerview.widget.DiffUtil
import com.kova700.someonesdiary.data.source.unsplash.remote.Photo

class ImageListDiffUtil : DiffUtil.ItemCallback<Photo>() {
    override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem == newItem
    }
}