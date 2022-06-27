package com.farhanhp.countriesdb.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.farhanhp.countriesdb.MainActivityViewModel
import com.farhanhp.countriesdb.R
import com.farhanhp.countriesdb.data.Country
import com.farhanhp.countriesdb.data.countries
import com.farhanhp.countriesdb.databinding.FragmentMainScreenBinding

class MainScreenFragment : Fragment() {
  private val activityViewModel: MainActivityViewModel by activityViewModels()
  private lateinit var binding: FragmentMainScreenBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentMainScreenBinding.inflate(layoutInflater)
    binding.countriesRv.adapter = CountriesAdapter(
      countries.map { CountriesAdapterItem(it, false) },
      this::onFavoriteButtonClick,
      this::onAdapterItemClick
    )

    return binding.root
  }

  private fun onFavoriteButtonClick(countryId: Int) {

  }

  private fun onAdapterItemClick(country: Country) {
    activityViewModel.selectedCountry = country
    findNavController().navigate(R.id.action_mainScreenFragment_to_detailCountryScreenFragment)
  }
}