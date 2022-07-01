package com.farhanhp.countriesdb.views.favorite_button

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.farhanhp.countriesdb.R
import com.farhanhp.countriesdb.data.AppDatabaseProvider
import com.farhanhp.countriesdb.data.Country
import com.farhanhp.countriesdb.dp
import com.google.android.material.button.MaterialButton
import kotlinx.coroutines.launch

class FavoriteButtonView @JvmOverloads constructor(
  context: Context, attrs: AttributeSet?, defStyleAttrs: Int = 0
): MaterialButton(context, attrs, defStyleAttrs) {
  private var viewModel = FavoriteButtonViewModel()

  init {
    backgroundTintList = ContextCompat.getColorStateList(context, R.color.white)
    iconTint = ContextCompat.getColorStateList(context, R.color.blue)
    cornerRadius = 20.dp
    gravity = Gravity.CENTER_VERTICAL
    typeface = ResourcesCompat.getFont(context, R.font.poppins_medium)
    setOnClickListener(::onClick)
  }

  private fun onClick(view: View) {
    findViewTreeLifecycleOwner()!!.lifecycleScope.launch {
      viewModel.onFavoriteButtonClickAsync().await()
      Toast.makeText(context, context.getString(
        if(viewModel.isFavorite) R.string.add_favorite_toast_msg
        else R.string.delete_favorite_toast_msg
      ), Toast.LENGTH_SHORT).show()
    }
  }

  fun setParams(country: Country) {
    viewModel.setParams(country, AppDatabaseProvider(context))
  }

  override fun onAttachedToWindow() {
    super.onAttachedToWindow()
    viewModel.loading.observe(findViewTreeLifecycleOwner()!!, ::onLoadingChange)
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
}