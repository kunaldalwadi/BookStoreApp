package com.example.bookstoreapp;

import android.os.Bundle;

import com.example.bookstoreapp.databinding.MainActivityBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class MainActivity extends AppCompatActivity {
    
    private MainActivityBinding mMainActivityBinding;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        mMainActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        
//        setContentView(R.layout.activity_main);
    }
}