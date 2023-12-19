package com.kova700.someonesdiary.view.makediary.imagesearch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.kova700.someonesdiary.R
import com.kova700.someonesdiary.data.source.unsplash.remote.Photo
import com.kova700.someonesdiary.databinding.ItemImageSearchBinding
import javax.inject.Inject

class ImageSearchListAdpater @Inject constructor() :
    ListAdapter<Photo, ImageListViewHolder>(ImageListDiffUtil()) {
    var onItemClick: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageListViewHolder {
        val binding =
            ItemImageSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageListViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: ImageListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int = R.layout.item_image_search
}