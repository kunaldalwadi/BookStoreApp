package com.example.bookstoreapp.model;

import com.example.bookstoreapp.BR;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "books_table", foreignKeys = @ForeignKey(entity = Category.class, parentColumns = "category_id", childColumns = "book_category_id", onDelete = CASCADE))
public class Book extends BaseObservable {
    
    @PrimaryKey(autoGenerate = true)
    private int book_id;
    
    @ColumnInfo(name = "book_name")
    private String book_name;
    
    @ColumnInfo(name = "book_price")
    private String book_price;
    
    @ColumnInfo(name = "book_category_id")
    private int book_category_id;
    
    @Ignore
    public Book() {
    }
    
    public Book(int book_id, String book_name, String book_price, int book_category_id) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_price = book_price;
        this.book_category_id = book_category_id;
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
    public int getBook_category_id() {
        return book_category_id;
    }
    
    public void setBook_category_id(int book_category_id) {
        this.book_category_id = book_category_id;
        notifyPropertyChanged(BR.book_category_id);
    }
}
