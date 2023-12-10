package com.kova700.someonesdiary.view.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import coil.load
import com.kova700.someonesdiary.databinding.ActivityDetailDiaryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailDiaryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailDiaryBinding
    private val mainViewModel by viewModels<DetailDiaryViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailDiaryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUIComponent()
    }

    private fun initUIComponent() {
        val circularProgressDrawable = CircularProgressDrawable(binding.root.context)
            .apply {
                strokeWidth = 5f
                centerRadius = 30f
                start()
            }
        //TODO : 이미지 사이즈 ratio 맞춰서 보이게 반영
        binding.ivCoverImgDetailDiary.load(mainViewModel.selectedItem.imgUrl) {
            placeholder(circularProgressDrawable)
        }
        binding.tvTitleDetailDiary.text = mainViewModel.selectedItem.title
        binding.tbHeartDetailDiary.setOnClickListener {
        }
    }
}