package com.farhanhp.countriesdb.views.favorite_button

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farhanhp.countriesdb.data.AppDatabaseProvider
import com.farhanhp.countriesdb.data.Country
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

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
      launch(Dispatchers.Default) {
        this@FavoriteButtonViewModel.country = country
        delay(5000)
        isFavorite = appDatabaseProvider.db.countryDao().findFavoriteCountryById(country.id) != null
      }
    }
}