package com.example.final_project;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "myDB", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE transactions (amount VARCHAR(20))";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS transactions (amount VARCHAR(20))";
        onCreate(sqLiteDatabase);

    }

    public void addTransaction(String amount){
        SQLiteDatabase db= getWritableDatabase();
        db.execSQL("INSERT INTO transactions VALUES(?)", new Object[]{ amount });
        db.close();
    }

    public List<String> getTransactions(){
        List<String> transactions= new ArrayList<>();
        SQLiteDatabase db= getReadableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM transactions", null);
        while (cursor.moveToNext()){
            String transaction = cursor.getString(0);
            transactions.add(transaction);
        }
        db.close();
        return transactions;
    }

    public void deleteTransaction(){
        SQLiteDatabase db= getWritableDatabase();
        db.execSQL("DELETE FROM transactions");
        db.close();
    }
}
