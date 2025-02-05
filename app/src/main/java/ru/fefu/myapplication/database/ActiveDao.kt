package ru.fefu.myapplication.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ru.fefu.myapplication.active.Active


@Dao
interface ActiveDao {

    @Query("select * from actives")
    fun getAllActives(): LiveData<List<Active>>

    @Query("select * from actives where id=:id")
    fun getById(id: Int): Active

    @Insert
    fun insert(active: Active)

    @Insert
    fun insertAll(vararg actives: Active)

    @Delete
    fun delete(active: Active)
}