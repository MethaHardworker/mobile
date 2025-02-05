package ru.fefu.myapplication.database

import android.content.Context
import androidx.room.Room

object Dap {
    lateinit var db: MyDB

    fun init(context: Context) {
        db = Room.databaseBuilder(
            context,
            MyDB::class.java,
            "my_database"
        ).allowMainThreadQueries().build()
    }

}