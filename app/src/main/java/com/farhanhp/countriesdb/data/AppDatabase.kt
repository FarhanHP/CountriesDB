package com.farhanhp.countriesdb.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavoriteCountry::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
  abstract fun favoriteCountryDao(): FavoriteCountryDao
}