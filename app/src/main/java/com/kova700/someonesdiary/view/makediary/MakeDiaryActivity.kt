package com.kova700.someonesdiary.view.makediary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.kova700.someonesdiary.R
import com.kova700.someonesdiary.databinding.ActivityMainBinding
import com.kova700.someonesdiary.databinding.ActivityMakeDiaryBinding
import dagger.hilt.android.AndroidEntryPoint

//TODO : 불러온 이미지 ratio에 맞게 ImageView 높이 반영
@AndroidEntryPoint
class MakeDiaryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMakeDiaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMakeDiaryBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}