package com.example.bookstoreapp;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Books")
public class Book extends BaseObservable {
    
    @PrimaryKey(autoGenerate = true)
    private int book_id;
    
    @ColumnInfo(name = "book_name")
    private String book_name;
    
    @ColumnInfo(name = "book_price")
    private String book_price;
    
    //TODO: Add Foreign Key.
    @ColumnInfo(name = "book_category")
    private String book_category;
    
    @Ignore
    public Book() {
    }
    
    public Book(int book_id, String book_name, String book_price, String book_category) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_price = book_price;
        this.book_category = book_category;
    }
    
    @Bindable
    public int getBook_id() {
        return book_id;
    }
    
    public void setBook_id(int book_id) {
        this.book_id = book_id;
        notifyPropertyChanged(BR.book_id);
    }
    
    @Bindable
    public String getBook_name() {
        return book_name;
    }
    
    public void setBook_name(String book_name) {
        this.book_name = book_name;
        notifyPropertyChanged(BR.book_name);
    }
    
    @Bindable
    public String getBook_price() {
        return book_price;
    }
    
    public void setBook_price(String book_price) {
        this.book_price = book_price;
        notifyPropertyChanged(BR.book_price);
    }
    
    @Bindable
    public String getBook_category() {
        return book_category;
    }
    
    public void setBook_category(String book_category) {
        this.book_category = book_category;
        notifyPropertyChanged(BR.book_category);
    }
}
