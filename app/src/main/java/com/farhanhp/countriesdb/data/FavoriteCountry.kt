package com.farhanhp.countriesdb.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_country")
data class FavoriteCountry(
  val countryId: Int,
  @PrimaryKey(autoGenerate = true)
  val id: Int = 0,
)
