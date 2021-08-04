package com.example.bookstoreapp.model;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.LiveData;

public class CategoryRepository {
    
    private CategoryDAO mCategoryDAO;
    private LiveData<List<Category>> mCategories;
    
    public CategoryRepository(Application application) {
        
        BookStoreAppDatabase bookStoreAppDatabase = BookStoreAppDatabase.getInstance(application);
        mCategoryDAO = bookStoreAppDatabase.getCategoryDAO();
    
    }
    
//    Why we didn't use AsycTask for getBooks and getCategories methods?
//    One of the ways to query data in room database is by using Livedata,
//    which can be used on the main thread as it is asynchronous.
//    As we are wrapping returned data into LiveData, query gets executed on background thread
//    by default.
//    Since BookDAO's getAllBooks and getAllCatogories methods returns live data,
//    we don't have to use AsyncTask in the Repository class.
    
    public LiveData<List<Category>> getCategories() {
        return mCategoryDAO.getAllCategories();
    }
    
    public void insertCategory(Category category)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
        
                mCategoryDAO.insertCategory(category);
                
            }
        }).start();
    }
    
    public void updateCategory(Category category)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                
                mCategoryDAO.updateCategory(category);
                
            }
        }).start();
    }
    
    public void deleteCategory(Category category)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                
                mCategoryDAO.deleteCategory(category);
                
            }
        }).start();
    }
    
    
}
