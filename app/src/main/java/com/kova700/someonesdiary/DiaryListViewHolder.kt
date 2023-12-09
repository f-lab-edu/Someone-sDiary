package com.kova700.someonesdiary

import android.graphics.drawable.BitmapDrawable
import androidx.core.view.marginEnd
import androidx.core.view.marginStart
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import coil.ImageLoader
import coil.load
import coil.request.ImageRequest
import com.kova700.someonesdiary.databinding.ItemDiaryBinding

class DiaryListViewHolder(
    private val binding: ItemDiaryBinding,
    private val itemClickListener: ((Int) -> Unit)?,
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.cvItemDiary.setOnClickListener {
            itemClickListener?.invoke(absoluteAdapterPosition)
        }
    }

    fun bind(diaryListItem: DiaryListItem) {

        val circularProgressDrawable = CircularProgressDrawable(binding.root.context)
            .apply {
                strokeWidth = 5f
                centerRadius = 30f
                start()
            }

        //이미지 가로 세로 사이즈 구해야함
        //Todo : Unsplash에서 가로 세로 너비 데이터 가져오는 방식으로 수정되면 삭제될 예정
        val request = ImageRequest.Builder(binding.root.context)
            .data(diaryListItem.imgUrl)
            .target { result ->
                val bitmap = (result as BitmapDrawable).bitmap
                val ratio = bitmap.height / bitmap.width.toFloat()
                val targetWidth =
                    binding.root.context.getDeviceWidthPixels() / 3 - (binding.cvItemDiary.marginStart + binding.cvItemDiary.marginEnd)
                val targetHeight = (targetWidth * ratio).toInt()

                binding.cvItemDiary.layoutParams =
                    binding.cvItemDiary.layoutParams.apply {
                        width = targetWidth
                    }

                binding.ivCoverImgItemDiary.layoutParams =
                    binding.ivCoverImgItemDiary.layoutParams.apply {
                        width = targetWidth
                        height = targetHeight
                    }
            }
            .build()
        ImageLoader(binding.root.context).enqueue(request)


        binding.ivCoverImgItemDiary.load(diaryListItem.imgUrl) {
            placeholder(circularProgressDrawable)
        }

        binding.tvCreatedDateItemDiary.text = diaryListItem.createdDate
        binding.tvTitleItemDiary.text = diaryListItem.title
    }

}