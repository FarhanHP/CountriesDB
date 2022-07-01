package com.farhanhp.countriesdb.data

import android.content.Context
import androidx.room.Room

class AppDatabaseProvider(
  private val applicationContext: Context
) {
  private val db: AppDatabase
    get() = Room.databaseBuilder(
      applicationContext,
      AppDatabase::class.java, "CountriesDB"
    ).build()

  fun isFavoriteCountry(country: Country) =
    db.favoriteCountryDao().findFavoriteCountryByCountryId(country.id) != null

  fun addFavoriteCountry(country: Country) {
    db.favoriteCountryDao().insertFavoriteCountry(FavoriteCountry(country.id))
  }

  fun deleteFavoriteCountry(country: Country) {
    db.favoriteCountryDao().deleteFavoriteCountryByCountryId(country.id)
  }
}