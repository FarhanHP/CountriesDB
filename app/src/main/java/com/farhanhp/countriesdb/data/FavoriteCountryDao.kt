package com.farhanhp.countriesdb.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface FavoriteCountryDao {
  @Query("SELECT * FROM favorite_country WHERE countryId = :countryId")
  fun findFavoriteCountryByCountryId(countryId: Int): FavoriteCountry?

  @Insert(onConflict = REPLACE)
  fun insertFavoriteCountry(favoriteCountry: FavoriteCountry)

  @Query("DELETE FROM favorite_country WHERE countryId = :countryId")
  fun deleteFavoriteCountryByCountryId(countryId: Int)
}