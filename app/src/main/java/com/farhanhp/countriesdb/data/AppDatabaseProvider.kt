package com.farhanhp.countriesdb.data

import android.content.Context
import androidx.room.Room

class AppDatabaseProvider(
  private val applicationContext: Context
) {
  val db: AppDatabase
    get() = Room.databaseBuilder(
      applicationContext,
      AppDatabase::class.java, "CountriesDB"
    ).build()
}