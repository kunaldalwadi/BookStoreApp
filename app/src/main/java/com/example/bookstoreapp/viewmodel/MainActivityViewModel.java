package com.example.bookstoreapp.viewmodel;

import android.app.Application;

import com.example.bookstoreapp.model.Book;
import com.example.bookstoreapp.model.BookRepository;
import com.example.bookstoreapp.model.Category;
import com.example.bookstoreapp.model.CategoryRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


//We extend AndroidViewModel when we know we want to use Application Context.
//Else we can only extend ViewModel
//In this project when we created Repository we are passing Application context
//hence, we need to extend AndroidViewmodel.

public class MainActivityViewModel extends AndroidViewModel {
    
    private CategoryRepository mCategoryRepository;
    private BookRepository mBookRepository;
    private LiveData<List<Category>> allCategories;
    private LiveData<List<Book>> allBooks;
    private LiveData<List<Book>> bookInCategory;
    
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        
        mCategoryRepository = new CategoryRepository(application);
        mBookRepository = new BookRepository(application);
        
    }
    
    public LiveData<List<Category>> getAllCategories() {
        allCategories = mCategoryRepository.getCategories();
        return allCategories;
    }
    
    public LiveData<List<Book>> getAllBooks() {
        allBooks = mBookRepository.getBooks();
        return allBooks;
    }
    
    public LiveData<List<Book>> getBookInCategory(int categoryId) {
        bookInCategory = mBookRepository.getBooks(categoryId);
        return bookInCategory;
    }
    
    public void insertBook(Book book)
    {
        mBookRepository.insertBook(book);
    }
    
    public void updateBook(Book book)
    {
        mBookRepository.updateBook(book);
    }
    
    public void deleteBook(Book book)
    {
        mBookRepository.deleteBook(book);
    }
}
