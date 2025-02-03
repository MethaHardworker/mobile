package ru.fefu.myapplication.active


import java.util.ArrayList
import java.util.Date
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.toDuration

open class Content
data class Active(val distance: Int, val duration: Duration, val activity: String, val date: Date, val user: String?) : Content()
data class Divider(val date: Date) : Content()


val activeListPersonal: ArrayList<Content> = arrayListOf(
    Divider(Date(2025-1900, 1, 25)),
    Active(1000, 60.toDuration(DurationUnit.MINUTES), "Велосипед", Date(2025 - 1900, 1, 25), null),
    Divider(Date(2022 - 1900, 5, 22)),
    Active(14320, 166.toDuration(DurationUnit.MINUTES), "Серфинг", Date(2022 - 1900, 5, 22), null),
    )


val activeListTotal: ArrayList<Content> = arrayListOf(
    Divider(Date(2025-1900, 1, 25)),
    Active(1000, 60.toDuration(DurationUnit.MINUTES), "Велосипед", Date(2025 - 1900, 1, 25), "@totalbuster"),
    Divider(Date(2025-1900, 5, 22)),
    Active(14320, 166.toDuration(DurationUnit.MINUTES), "Серфинг", Date(2022 - 1900, 5, 22), "@totalbuster"),
    Divider(Date(1992-1900, 6, 8)),
    Active(61354, 41.toDuration(DurationUnit.MINUTES), "Ралли", Date(1992 - 1900, 5, 8),"@collinMCRay")
)