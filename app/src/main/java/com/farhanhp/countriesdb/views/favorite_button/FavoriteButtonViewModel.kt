package com.farhanhp.countriesdb.views.favorite_button

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farhanhp.countriesdb.data.AppDatabaseProvider
import com.farhanhp.countriesdb.data.Country
import kotlinx.coroutines.launch

class FavoriteButtonViewModel(
  private val appDatabaseProvider: AppDatabaseProvider
): ViewModel() {
  lateinit var country: Country
    private set

  var isFavorite = false
    private set

  private val _isLoading = MutableLiveData(false)
  val loading: LiveData<Boolean>
    get() = _isLoading

  fun setCountry(country: Country) =
    viewModelScope.launch {
      _isLoading.value = true
      this@FavoriteButtonViewModel.country = country
      //isFavorite = appDatabaseProvider.db.countryDao().findFavoriteCountryById(country.id) != null
      _isLoading.value = false
    }
}