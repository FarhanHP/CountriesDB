package com.farhanhp.countriesdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
  private val viewModel: MainActivityViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }
}