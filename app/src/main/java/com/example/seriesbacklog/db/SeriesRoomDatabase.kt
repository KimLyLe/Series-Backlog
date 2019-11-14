package com.example.seriesbacklog.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.seriesbacklog.model.Series

@Database(entities = [Series::class], version = 1, exportSchema = false)
abstract class SeriesRoomDatabase : RoomDatabase() {

    abstract fun seriesDao(): SeriesDao

    companion object {
        private const val DATABASE_NAME = "REMINDER_DATABASE"

        @Volatile
        private var reminderRoomDatabaseInstance: SeriesRoomDatabase? = null

        fun getDatabase(context: Context): SeriesRoomDatabase? {
            if (reminderRoomDatabaseInstance == null) {
                synchronized(SeriesRoomDatabase::class.java) {
                    if (reminderRoomDatabaseInstance == null) {
                        reminderRoomDatabaseInstance = Room.databaseBuilder(
                            context.applicationContext,
                            SeriesRoomDatabase::class.java, DATABASE_NAME
                        )
                            .allowMainThreadQueries()
                            .build()
                    }
                }
            }
            return reminderRoomDatabaseInstance
        }
    }

}
