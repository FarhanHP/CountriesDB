package com.farhanhp.countriesdb

import android.os.Build.VERSION.SDK_INT
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

    val navController = (supportFragmentManager.findFragmentById(R.id.main_nav_host) as NavHostFragment).navController

    if(SDK_INT >= 31) {
      navController.navigate(R.id.mainScreenFragment)
    }

    binding.toolbar.apply {
      setupWithNavController(navController, AppBarConfiguration(
        topLevelDestinationIds = setOf(R.id.mainScreenFragment),
        fallbackOnNavigateUpListener = ::onSupportNavigateUp
      ))
      inflateMenu(R.menu.main_toolbar_menu)
    }

    setContentView(binding.root)
  }
}