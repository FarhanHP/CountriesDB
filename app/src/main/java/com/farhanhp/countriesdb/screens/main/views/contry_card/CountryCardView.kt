package com.farhanhp.countriesdb.screens.main.views.contry_card

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.bumptech.glide.Glide
import com.farhanhp.countriesdb.R
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

  fun setImageUrl(imageUrl: String) {
    Glide.with(this).load(imageUrl).centerCrop().into(binding.countryFlagImg)
  }

  fun setCountryName(countryName: String) {
    binding.countryName.text = countryName
  }

  fun setFavoriteButton(isFavorite: Boolean) {
    binding.favoriteButton.apply {
      icon = context.getDrawable(
        if(isFavorite)
          R.drawable.ic_baseline_favorite_24
        else
          R.drawable.ic_baseline_favorite_border_24
      )
      text = context.getString(
        if (isFavorite)
          R.string.remove_favorite
        else
          R.string.add_favorite
      )
    }
  }

  fun setFavoriteButtonOnClickListener(listener: OnClickListener) {
    binding.favoriteButton.setOnClickListener(listener)
  }
}