package ru.fefu.myapplication.active


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.ArrayList
import java.util.Date

open class Content

@Entity(tableName = "actives")
data class Active(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "active_type")  val activity: EnumActiveTypes,
    @ColumnInfo(name = "date_start") val startDate: Date,
    @ColumnInfo(name = "date_end") val endDate: Date,
) : Content()

data class Divider(val date: Date) : Content()


val activeListPersonal: ArrayList<Content> = arrayListOf()


val activeListTotal: ArrayList<Content> = arrayListOf()