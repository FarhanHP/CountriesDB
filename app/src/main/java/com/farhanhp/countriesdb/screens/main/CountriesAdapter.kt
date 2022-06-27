package com.farhanhp.countriesdb.screens.main

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.farhanhp.countriesdb.data.Country
import com.farhanhp.countriesdb.screens.main.views.contry_card.CountryCardView

class CountriesAdapter(
  _items: List<CountriesAdapterItem>,
  var favoriteButtonClickCallback: (countryId: Int) -> Unit,
  var onItemCLickCallback: (country: Country) -> Unit
): RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {
  var items: List<CountriesAdapterItem> = _items
    set(value) {
      field = value
      notifyDataSetChanged()
    }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
    ViewHolder(CountryCardView(parent.context))

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    items[position].let { item ->
      holder.view.apply {
        setImageUrl(item.country.flagImg)
        setCountryName(item.country.name)
        setFavoriteButton(item.isFavorite)
        setFavoriteButtonOnClickListener {
          favoriteButtonClickCallback(item.country.id)
        }
        setOnClickListener {
          onItemCLickCallback(item.country)
        }
      }
    }
  }

  override fun getItemCount() = items.size

  inner class ViewHolder(
    val view: CountryCardView
  ): RecyclerView.ViewHolder(view)
}