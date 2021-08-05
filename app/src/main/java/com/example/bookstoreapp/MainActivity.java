package com.example.bookstoreapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.bookstoreapp.databinding.MainActivityBinding;
import com.example.bookstoreapp.model.Book;
import com.example.bookstoreapp.model.Category;
import com.example.bookstoreapp.viewmodel.MainActivityViewModel;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {
    
    private static final String TAG = MainActivity.class.getSimpleName();
    private MainActivityBinding mMainActivityBinding;
    private MainActivityViewModel mMainActivityViewModel;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        mMainActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mMainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        
        mMainActivityViewModel.getAllCategories().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                for (Category c : categories)
                {
                    Log.d(TAG, "onChanged: " + c.getCategory_name());
                }
            }
        });
        
        mMainActivityViewModel.getBookInCategory(3).observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(List<Book> books) {
                for (Book b: books)
                {
                    Log.d(TAG, "onChanged: " + b.getBook_name());
                }
            }
        });
    }
    
    public class MainActivityHandlers{
        
        public void onFabClicked(View view){
            Toast.makeText(getApplicationContext(), "FAb clicked..", Toast.LENGTH_SHORT).show();
        }
        
    }
}