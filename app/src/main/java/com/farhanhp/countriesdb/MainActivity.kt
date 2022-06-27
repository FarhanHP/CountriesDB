package com.farhanhp.countriesdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.farhanhp.countriesdb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private val viewModel: MainActivityViewModel by viewModels()
  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

    val navController = (supportFragmentManager.findFragmentById(R.id.main_nav_host) as NavHostFragment).navController
    binding.toolbar.setupWithNavController(navController, AppBarConfiguration(
      topLevelDestinationIds = setOf(R.id.mainScreenFragment),
      fallbackOnNavigateUpListener = ::onSupportNavigateUp
    ))
  }

  fun getAppBar() = binding.appbar
}