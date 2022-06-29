package com.farhanhp.countriesdb.screens.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.farhanhp.countriesdb.databinding.FragmentAboutScreenBinding
import com.farhanhp.countriesdb.screens.MainActivityFragment

class AboutScreenFragment : MainActivityFragment() {
  private lateinit var binding: FragmentAboutScreenBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentAboutScreenBinding.inflate(layoutInflater)
    return binding.root
  }
}