package com.example.seriesbacklog.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.seriesbacklog.model.Converters
import com.example.seriesbacklog.model.Series


@Database(entities = [Series::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class SeriesRoomDatabase : RoomDatabase() {

    abstract fun seriesDao(): SeriesDao

    companion object {
        private const val DATABASE_NAME = "SERIES_DATABASE"

        @Volatile
        private var INSTANCE: SeriesRoomDatabase? = null

        fun getDatabase(context: Context): SeriesRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(SeriesRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            SeriesRoomDatabase::class.java, DATABASE_NAME
                        )
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }

}
