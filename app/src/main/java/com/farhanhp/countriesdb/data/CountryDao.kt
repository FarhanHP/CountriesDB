package com.farhanhp.countriesdb.data

import androidx.room.Dao
import androidx.room.Query

@Dao
interface CountryDao {
  @Query("SELECT * FROM country WHERE id = :countryId")
  fun findFavoriteCountryById(countryId: Int): Country?
}