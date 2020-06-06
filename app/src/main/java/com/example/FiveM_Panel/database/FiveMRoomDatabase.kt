package com.example.FiveM_Panel.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [FiveM::class], version = 1, exportSchema = false)
abstract class FiveMRoomDatabase : RoomDatabase() {

    abstract fun gameDao(): FiveMDao

    companion object {
        private const val DATABASE_NAME = "FIVEM_PANELDB"

        @Volatile
        private var INSTANCE: FiveMRoomDatabase? = null

        fun getDatabase(context: Context): FiveMRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(FiveMRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            FiveMRoomDatabase::class.java, DATABASE_NAME
                        )
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }

}
