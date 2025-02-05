package ru.fefu.myapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import ru.fefu.myapplication.active.Active
import java.util.Date

object DateConverter {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}


@Database(entities = [Active::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class MyDB : RoomDatabase() {
    abstract fun activeDao(): ActiveDao
}

//val MIGRATION_1_2 = object : Migration(1, 2) {
//    override fun migrate(db: SupportSQLiteDatabase) {
//        db.execSQL("create table actives")
//    }
//}