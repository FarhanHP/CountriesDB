package com.farhanhp.countriesdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.farhanhp.countriesdb.databinding.ActivityMainBinding
import com.google.android.material.appbar.AppBarLayout

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding

  val appBar: AppBarLayout
    get() = binding.appbar

  val toolbar: Toolbar
    get() = binding.toolbar

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

    val navController = (supportFragmentManager.findFragmentById(R.id.main_nav_host) as NavHostFragment).navController
    binding.toolbar.apply {
      setupWithNavController(navController, AppBarConfiguration(
        topLevelDestinationIds = setOf(R.id.mainScreenFragment),
        fallbackOnNavigateUpListener = ::onSupportNavigateUp
      ))
      inflateMenu(R.menu.main_toolbar_menu)
    }
  }
}