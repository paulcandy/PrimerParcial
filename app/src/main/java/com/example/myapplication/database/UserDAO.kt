package com.example.myapplication.database

import androidx.room.Dao
import androidx.room.*
import Entities.User


@Dao
public interface userDAO {

    @Query("SELECT * FROM users ORDER BY id")
    fun loadAllPersons(): MutableList<User?>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPerson(user: User?)

    @Update
    fun updatePerson(user: User?)

    @Delete
    fun delete(user: User?)

    @Query("SELECT * FROM users WHERE id = :id")
    fun loadPersonById(id: Int): User?

}