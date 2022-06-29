package com.farhanhp.countriesdb.screens.main

import androidx.lifecycle.ViewModel
import com.farhanhp.countriesdb.data.Country
import com.farhanhp.countriesdb.data.DummyProvider

class MainScreenFragmentViewModel: ViewModel() {
  val countries: List<Country>
    get() = DummyProvider.countries
}