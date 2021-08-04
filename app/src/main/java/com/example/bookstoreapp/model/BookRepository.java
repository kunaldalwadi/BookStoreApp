package com.example.bookstoreapp.model;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.LiveData;

public class BookRepository {
    
    private BookDAO mBookDAO;
    private LiveData<List<Book>> mBooks;
    
    
    //I dont know this yet, but a Repository class will always have
    // Application object as parameter.
    public BookRepository(Application application) {
        BookStoreAppDatabase bookStoreAppDatabase = BookStoreAppDatabase.getInstance(application);
        mBookDAO = bookStoreAppDatabase.getBookDAO();
    }
    
    public LiveData<List<Book>> getBooks() {
        return mBookDAO.getAllBooks();
    }
    
    public LiveData<List<Book>> getBooks(int categoryId) {
        return mBookDAO.getBooksInCategory(categoryId);
    }
    
    public void insertBook(Book book)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                
                mBookDAO.insertBook(book);
                
            }
        }).start();
    }
    
    public void updateBook(Book book)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                
                mBookDAO.updateBook(book);
                
            }
        }).start();
    }
    
    public void deleteBook(Book book)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                
                mBookDAO.deleteBook(book);
                
            }
        }).start();
    }
    
}
