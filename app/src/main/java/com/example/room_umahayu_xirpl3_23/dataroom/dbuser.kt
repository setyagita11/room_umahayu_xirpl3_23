package com.example.room_umahayu_xirpl3_23.dataroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//membuat entitas dan mendaftarkan table atau entity
@Database(entities = [User::class], version = 1)

abstract class dbuser : RoomDatabase() {
    abstract fun userDao() : userDAO
    companion object{

        @Volatile
        private var INSTANCE :dbuser?=null
        private var key = Any()
        operator fun invoke(context: Context) = INSTANCE ?: synchronized(key){
            INSTANCE ?: buildDatabase(context).also {
                INSTANCE= it
            }
        }
        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext, dbuser::class.java, "cobaxirpl3.db"
        ).fallbackToDestructiveMigration().build()
    }
}
