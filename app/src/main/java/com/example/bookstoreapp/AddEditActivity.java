package com.example.bookstoreapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.bookstoreapp.databinding.AddEditActivityBinding;

public class AddEditActivity extends AppCompatActivity {
    
    private AddEditActivityBinding mAddEditActivityBinding;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        mAddEditActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_edit);
        
//        setContentView(R.layout.activity_add_edit);
    }
}