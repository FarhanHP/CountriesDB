package com.farhanhp.countriesdb.screens.main

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.farhanhp.countriesdb.data.Country
import com.farhanhp.countriesdb.screens.main.views.contry_card.CountryCardView

class CountriesAdapter(
  private val items: List<Country>,
  var onItemCLickCallback: (country: Country) -> Unit
): RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
    ViewHolder(CountryCardView(parent.context))

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    items[position].let { item ->
      holder.view.apply {
        setCountry(item)
        setOnClickListener {
          onItemCLickCallback(item)
        }
      }
    }
  }

  override fun getItemCount() = items.size

  inner class ViewHolder(
    val view: CountryCardView
  ): RecyclerView.ViewHolder(view)
}