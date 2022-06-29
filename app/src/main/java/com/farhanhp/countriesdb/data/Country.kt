package com.farhanhp.countriesdb.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Country(
  @PrimaryKey
  val id: Int,
  val name: String,
  val description: String,
  val flagImg: String,
  val coatOfArmImg: String,
  val mapImg: String
)