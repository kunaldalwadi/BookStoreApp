package com.example.bookstoreapp.model;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Book.class, Category.class}, version = 1)
public abstract class BookStoreAppDatabase extends RoomDatabase {

    public abstract BookDAO getBookDAO();
    
    public abstract CategoryDAO getCategoryDAO();

    private static BookStoreAppDatabase instance;
    
    public static synchronized BookStoreAppDatabase getInstance(Context context) {
        if (instance == null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(), BookStoreAppDatabase.class, "BookStoreDatabase")
                           .fallbackToDestructiveMigration()
                           .addCallback(mCallback)
                           .build();
        }
        return instance;
    }
    
    private static RoomDatabase.Callback mCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            // Should be done in a separate thread.
            new InitDataAsyncTask(instance).execute();
            
        }
    
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };
    
   public static class InitDataAsyncTask extends AsyncTask<Void,Void,Void>{
    
       private BookDAO mBookDAO;
       private CategoryDAO mCategoryDAO;
    
       public InitDataAsyncTask(BookStoreAppDatabase bookStoreAppDatabase) {
           mBookDAO = bookStoreAppDatabase.getBookDAO();
           mCategoryDAO = bookStoreAppDatabase.getCategoryDAO();
       }
    
       @Override
       protected Void doInBackground(Void... voids) {
       
           Category category1 = new Category(1,"Sci-Fi", "Scientific Fiction");
           Category category2 = new Category(2,"Romance", "Romance Fiction");
           Category category3 = new Category(3,"Supernatural", "Supernatural Fiction");
           Category category4 = new Category(4,"Horror", "Horror Fiction");
           
           mCategoryDAO.insertCategory(category1);
           mCategoryDAO.insertCategory(category2);
           mCategoryDAO.insertCategory(category3);
           mCategoryDAO.insertCategory(category4);
           
           Book book1 = new Book(1,"Who knows","$10",2);
           Book book2 = new Book(2,"Wolves","$20",3);
           Book book3 = new Book(3,"Ghoul","$15",1);
           Book book4 = new Book(4,"Magic","$25",4);
           Book book5 = new Book(5,"Horizon","$30",3);
           
           mBookDAO.insertBook(book1);
           mBookDAO.insertBook(book2);
           mBookDAO.insertBook(book3);
           mBookDAO.insertBook(book4);
           mBookDAO.insertBook(book5);
           
           return null;
       }
   }
    
    
}
