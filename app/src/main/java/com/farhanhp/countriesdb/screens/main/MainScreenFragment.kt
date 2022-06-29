package com.farhanhp.countriesdb.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.farhanhp.countriesdb.data.Country
import com.farhanhp.countriesdb.databinding.FragmentMainScreenBinding
import com.farhanhp.countriesdb.screens.MainActivityWithAboutFragment

class MainScreenFragment : MainActivityWithAboutFragment() {
  private val viewModel: MainScreenFragmentViewModel by viewModels()
  private lateinit var binding: FragmentMainScreenBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentMainScreenBinding.inflate(layoutInflater)
    binding.countriesRv.adapter = CountriesAdapter(
      viewModel.countries.map { CountriesAdapterItem(it, false) },
      this::onFavoriteButtonClick,
      this::onAdapterItemClick
    )

    return binding.root
  }

  private fun onFavoriteButtonClick(countryId: Int) {

  }

  private fun onAdapterItemClick(country: Country) {
    activityViewModel.selectedCountry = country
    findNavController().navigate(MainScreenFragmentDirections.actionMainScreenFragmentToDetailCountryScreenFragment())
  }
}