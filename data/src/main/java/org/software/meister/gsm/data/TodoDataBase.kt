package org.software.meister.gsm.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Todo::class], exportSchema = true, version = 1)
abstract class TodoDataBase : RoomDatabase() {
    abstract fun getDao() : TodoDao
}