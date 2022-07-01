package com.farhanhp.countriesdb.screens.main.views.contry_card

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.bumptech.glide.Glide
import com.farhanhp.countriesdb.R
import com.farhanhp.countriesdb.data.Country
import com.farhanhp.countriesdb.databinding.ViewCountryCardBinding

class CountryCardView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? =  null,
  defStyleAttr: Int = 0
): FrameLayout(context, attrs, defStyleAttr) {
  private val binding: ViewCountryCardBinding

  init {
    binding = ViewCountryCardBinding.inflate(LayoutInflater.from(context), this, true)
  }

  override fun setOnClickListener(l: OnClickListener?) {
    binding.card.setOnClickListener(l)
  }

  fun setCountry(country: Country) {
    Glide.with(this).load(country.flagImg).centerCrop().into(binding.countryFlagImg)
    binding.countryName.text = country.name
    binding.favoriteButton.setParams(country)
  }
}