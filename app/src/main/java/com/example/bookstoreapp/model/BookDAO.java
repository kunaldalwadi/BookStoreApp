package com.example.bookstoreapp.model;

import java.util.List;

import androidx.lifecycle.LiveData;
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
    
    @Query("SELECT * FROM books_table")
    public LiveData<List<Book>> getAllBooks();
    
    @Query("SELECT * FROM books_table where book_category_id==:cat_id")
    public LiveData<List<Book>> getBooksInCategory(int cat_id);
    
}
