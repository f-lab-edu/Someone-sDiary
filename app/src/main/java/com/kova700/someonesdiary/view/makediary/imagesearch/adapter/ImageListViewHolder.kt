package com.kova700.someonesdiary.view.makediary.imagesearch.adapter

import androidx.core.view.marginEnd
import androidx.core.view.marginStart
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import coil.load
import com.kova700.someonesdiary.data.source.unsplash.remote.Photo
import com.kova700.someonesdiary.databinding.ItemImageSearchBinding
import com.kova700.someonesdiary.util.getDeviceWidthPixels

class ImageListViewHolder(
    private val binding: ItemImageSearchBinding,
    private val itemClickListener: ((Int) -> Unit)?
) : RecyclerView.ViewHolder(binding.root) {


    init {
        binding.cvImageSearch.setOnClickListener {
            itemClickListener?.invoke(absoluteAdapterPosition)
        }
    }

    fun bind(photo: Photo) {
        setViewHolderSizeToFit(photo)
        binding.ivImageSearch.load(photo.urls.full) {
            placeholder(circularProgressDrawable)
        }
    }

    private val circularProgressDrawable = CircularProgressDrawable(binding.root.context)
        .apply {
            strokeWidth = 5f
            centerRadius = 30f
            start()
        }

    private fun setViewHolderSizeToFit(photo: Photo) {
        val ratio = photo.height / photo.width.toFloat()
        val targetWidth =
            binding.root.context.getDeviceWidthPixels() / 3 - (binding.cvImageSearch.marginStart + binding.cvImageSearch.marginEnd)
        val targetHeight = (targetWidth * ratio).toInt()

        binding.cvImageSearch.layoutParams =
            binding.cvImageSearch.layoutParams.apply {
                width = targetWidth
            }

        binding.ivImageSearch.layoutParams =
            binding.ivImageSearch.layoutParams.apply {
                width = targetWidth
                height = targetHeight
            }
    }

}