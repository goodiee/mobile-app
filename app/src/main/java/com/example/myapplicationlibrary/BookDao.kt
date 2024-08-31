package com.example.myapplicationlibrary


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BookDao {
    @Query("SELECT * FROM books WHERE id = :bookId")
    suspend fun getBookById(bookId: Long): Book?
}
