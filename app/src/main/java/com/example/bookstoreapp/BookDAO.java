package com.example.bookstoreapp;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface BookDAO {
    
    @Insert
    public void insertBook(Book book);
    
    @Update
    public void updateBook(Book book);
    
    @Delete
    public void deleteBook(Book book);
    
    @Query("SELECT * FROM Books")
    public List<Book> getAllBooks();
    
}
