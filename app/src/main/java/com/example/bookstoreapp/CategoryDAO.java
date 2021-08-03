package com.example.bookstoreapp;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface CategoryDAO {
    
    @Insert
    public void insertCategory(Category category);
    
    @Update
    public void updateCategory(Category category);
    
    @Delete
    public void deleteCategory(Category category);
    
    @Query("SELECT * FROM categories")
    public List<Category> getAllCategories();
}
