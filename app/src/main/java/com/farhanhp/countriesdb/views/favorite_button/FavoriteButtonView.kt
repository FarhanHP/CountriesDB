package com.farhanhp.countriesdb.views.favorite_button

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

class FavoriteButtonView @JvmOverloads constructor(
  context: Context, attrs: AttributeSet?, defStyleAttrs: Int = 0
): FrameLayout(context, attrs, defStyleAttrs) {
  private val viewModel = FavoriteButtonViewModel()

  fun setCountryId(countryId: Int) {
    viewModel.countryId = countryId
  }
}