package com.farhanhp.countriesdb.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.farhanhp.countriesdb.R
import com.farhanhp.countriesdb.data.countries
import com.farhanhp.countriesdb.databinding.FragmentMainScreenBinding

class MainScreenFragment : Fragment() {
  private lateinit var binding: FragmentMainScreenBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentMainScreenBinding.inflate(layoutInflater)
    binding.countriesRv.adapter = CountriesAdapter(countries)

    return binding.root
  }
}