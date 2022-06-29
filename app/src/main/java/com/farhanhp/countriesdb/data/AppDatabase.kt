package com.farhanhp.countriesdb.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Country::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
  abstract fun countryDao(): CountryDao
}