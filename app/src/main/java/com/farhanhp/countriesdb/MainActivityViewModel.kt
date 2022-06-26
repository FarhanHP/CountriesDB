package com.farhanhp.countriesdb

import androidx.lifecycle.ViewModel
import com.farhanhp.countriesdb.data.Country

class MainActivityViewModel: ViewModel() {
  var selectedCountry: Country? = null
}