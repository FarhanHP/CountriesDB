package com.farhanhp.countriesdb.views.favorite_button

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farhanhp.countriesdb.data.AppDatabaseProvider
import com.farhanhp.countriesdb.data.Country
import kotlinx.coroutines.*

class FavoriteButtonViewModel: ViewModel() {
  lateinit var country: Country
    private set

  lateinit var appDatabaseProvider: AppDatabaseProvider

  var isFavorite = false
    private set

  private val _isLoading = MutableLiveData(false)
  val loading: LiveData<Boolean>
    get() = _isLoading

  fun setParams(country: Country, appDatabaseProvider: AppDatabaseProvider) {
    this.appDatabaseProvider = appDatabaseProvider
    this.country = country
    updateIsFavorite()
  }

  fun updateIsFavorite() {
    viewModelScope.launch {
      _isLoading.value = true
      withContext(Dispatchers.Default) {
        isFavorite = appDatabaseProvider.isFavoriteCountry(country)
      }
      _isLoading.value = false
    }
  }

  fun onFavoriteButtonClickAsync() =
    viewModelScope.async {
      _isLoading.value = true
      withContext(Dispatchers.Default) {
        if (isFavorite) {
          appDatabaseProvider.deleteFavoriteCountry(country)
        } else {
          appDatabaseProvider.addFavoriteCountry(country)
        }
      }
      isFavorite = !isFavorite
      _isLoading.value = false
    }
}