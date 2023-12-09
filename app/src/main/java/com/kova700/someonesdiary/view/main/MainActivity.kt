package com.kova700.someonesdiary.view.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.kova700.someonesdiary.view.makediary.MakeDiaryActivity
import com.kova700.someonesdiary.R
import com.kova700.someonesdiary.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavigation()
        initFabBtnClickListener()
    }

    private fun initNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.container_main) as NavHostFragment
        val navController = navHostFragment.findNavController()
        initBottomNavigationView(navController)
    }

    private fun initBottomNavigationView(navController: NavController) {
        binding.bnvMain.apply {
            setupWithNavController(navController)
        }
    }

    private fun initFabBtnClickListener() {
        binding.fabMain.setOnClickListener { moveMakeDiary() }
    }

    private fun moveMakeDiary() {
        val intent = Intent(this, MakeDiaryActivity::class.java)
        startActivity(intent)
    }
}