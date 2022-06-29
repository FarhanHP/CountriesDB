package com.farhanhp.countriesdb.screens.detail_country

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.farhanhp.countriesdb.data.Country
import com.farhanhp.countriesdb.data.DummyProvider
import com.farhanhp.countriesdb.databinding.FragmentDetailCountryScreenBinding
import com.farhanhp.countriesdb.screens.MainActivityWithAboutFragment

class DetailCountryScreenFragment : MainActivityWithAboutFragment() {
  private lateinit var binding: FragmentDetailCountryScreenBinding
  private val args: DetailCountryScreenFragmentArgs by navArgs()
  private val viewModel: DetailCountryScreenFragmentViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentDetailCountryScreenBinding.inflate(layoutInflater)

    viewModel.run {
      if(args.countryId > -1) {
        countryId = args.countryId
      }

      if(country == null) {
        country = activityViewModel.selectedCountry
      }

      if (country == null) {
        parentActivity.onBackPressed()
      }

      country?.let { country ->
        Glide.with(this@DetailCountryScreenFragment).apply {
          load(country.flagImg).into(binding.flagImg)
          load(country.coatOfArmImg).into(binding.coatOfArmImg)
          load(country.mapImg).into(binding.mapImg)
        }
        binding.countryDescription.text = country.description
      }
    }

    binding.shareButton.setOnClickListener(this::onShareButtonClickListener)

    return binding.root
  }

  private fun onShareButtonClickListener(view: View) {
    startActivity(Intent(Intent.ACTION_SEND).apply {
      type = "text/plain"
      putExtra(Intent.EXTRA_TEXT, "farhanhp.com/countriesdb/${viewModel.countryId}")
    })
  }
}