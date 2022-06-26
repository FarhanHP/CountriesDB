package com.farhanhp.countriesdb.screens.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.farhanhp.countriesdb.data.Country
import com.farhanhp.countriesdb.databinding.ViewHolderCountryBinding

class CountriesAdapter(
  private val items: List<CountriesAdapterItem>
): RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
    ViewHolder(ViewHolderCountryBinding.inflate(LayoutInflater.from(parent.context)))

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    items[position].let {
      holder.viewBinding.apply {
        Glide.with(root).load(it.country.flagImg).centerCrop().into(countryFlagImg)
        countryName.text = it.country.name
      }
    }
  }

  override fun getItemCount() = items.size

  inner class ViewHolder(
    val viewBinding: ViewHolderCountryBinding
  ): RecyclerView.ViewHolder(viewBinding.root)
}