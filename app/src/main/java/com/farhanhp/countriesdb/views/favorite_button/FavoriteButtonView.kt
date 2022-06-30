package com.farhanhp.countriesdb.views.favorite_button

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.Gravity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.TypefaceCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import com.farhanhp.countriesdb.R
import com.farhanhp.countriesdb.data.AppDatabaseProvider
import com.farhanhp.countriesdb.data.Country
import com.farhanhp.countriesdb.dp
import com.google.android.material.button.MaterialButton

class FavoriteButtonView @JvmOverloads constructor(
  context: Context, attrs: AttributeSet?, defStyleAttrs: Int = 0
): MaterialButton(context, attrs, defStyleAttrs), LifecycleOwner {
  private val viewModel = FavoriteButtonViewModel(AppDatabaseProvider(context))
  private val lifecycleRegistry = LifecycleRegistry(this)

  init {
    backgroundTintList = ContextCompat.getColorStateList(context, R.color.white)
    iconTint = ContextCompat.getColorStateList(context, R.color.blue)
    viewModel.loading.observe(this, this::onLoadingChange)
    cornerRadius = 20.dp
    gravity = Gravity.CENTER_VERTICAL
    typeface = ResourcesCompat.getFont(context, R.font.poppins_medium)
  }

  fun setCountry(country: Country) {
    viewModel.setCountry(country)
  }

  private fun onLoadingChange(isLoading: Boolean) {
    if(isLoading) {
      isEnabled = false
      isClickable = false
      isFocusable = false
      text = context.getString(R.string.loading)
      setTextColor(context.getColor(R.color.black))
    } else {
      isEnabled = true
      isClickable = true
      isFocusable = true
      setTextColor(context.getColor(R.color.blue))

      if(viewModel.isFavorite) {
        icon = context.getDrawable(R.drawable.ic_baseline_favorite_24)
        text = context.getString(R.string.remove_favorite)
      } else {
        icon = context.getDrawable(R.drawable.ic_baseline_favorite_border_24)
        text = context.getString(R.string.add_favorite)
      }
    }
  }
  override fun onAttachedToWindow() {
    super.onAttachedToWindow()
    lifecycleRegistry.currentState = Lifecycle.State.RESUMED
  }

  override fun onDetachedFromWindow() {
    super.onDetachedFromWindow()
    lifecycleRegistry.currentState = Lifecycle.State.DESTROYED
  }

  override fun getLifecycle() = lifecycleRegistry
}