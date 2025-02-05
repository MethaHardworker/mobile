package ru.fefu.myapplication.active


data class ActiveType(val name: EnumActiveTypes, val picture: Int)

enum class EnumActiveTypes(val typeName: String) {
    Bike ("Велосипед"),
    Run ("Бег"),
    Walk("Шаг"),
    Surf("Серфинг"),
    Rally("Ралли")
}