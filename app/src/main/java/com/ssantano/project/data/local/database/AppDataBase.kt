package com.ssantano.project.data.local.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class AppDataBase : RoomDatabase() {


  companion object {
    private const val DATABASE_NAME = "AppRoomDatabase.db"

    fun buildDatabase(applicationContext: Context) =
      Room.databaseBuilder(
        applicationContext,
        AppDataBase::class.java,
        DATABASE_NAME
      ).build()
  }

}
