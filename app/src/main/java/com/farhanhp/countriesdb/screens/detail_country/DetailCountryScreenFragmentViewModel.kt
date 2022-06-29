package com.farhanhp.countriesdb.screens.detail_country

import androidx.lifecycle.ViewModel
import com.farhanhp.countriesdb.data.Country
import com.farhanhp.countriesdb.data.DummyProvider

class DetailCountryScreenFragmentViewModel: ViewModel() {
  var country: Country? = null
  var countryId: Int
    get() = country!!.id
    set(value) {
      country = DummyProvider.getCountryById(value)
    }
}