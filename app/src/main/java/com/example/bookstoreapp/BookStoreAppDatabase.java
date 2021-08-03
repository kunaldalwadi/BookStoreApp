package com.example.bookstoreapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Book.class, Category.class}, version = 1)
public abstract class BookStoreAppDatabase extends RoomDatabase {

    public abstract BookDAO getBookDAO();
    
    public abstract CategoryDAO getCategoryDAO();

}
