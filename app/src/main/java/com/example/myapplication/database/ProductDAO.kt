package com.example.myapplication.database

import androidx.room.Dao
import Entities.Product
import Entities.User
import androidx.room.*

@Dao
interface ProductDAO {

    @Query("SELECT * FROM product ORDER BY id")
    fun loadAllProducts(): MutableList<Product?>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(product: Product?)

    @Update
    fun updateProduct(product: Product?)

    @Delete
    fun delete(product: Product?)

    @Query("SELECT * FROM product WHERE id = :id")
    fun loadProductById(id: Int): Product?

}