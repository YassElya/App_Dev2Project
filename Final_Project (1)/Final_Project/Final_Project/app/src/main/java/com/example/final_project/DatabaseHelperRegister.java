package com.example.final_project;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelperRegister extends SQLiteOpenHelper {

    public static final String DB_NAME = "account.db";
    public static final int DB_VERSION = 1;
    ContentValues contentValues= new ContentValues();


    public DatabaseHelperRegister(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table account (username varchar primary key, password varchar)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists account");
        onCreate(db);

    }

    public boolean addItems (int SSN, String firstName, String lastName,String middleName, String username,
                             String password,String confirmPassword) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("SSN", SSN);
        contentValues.put("firstName", firstName);
        contentValues.put("lastName", lastName);
        contentValues.put("middleName", middleName);
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("passConfirmation", confirmPassword);

        db.insert("account", null, contentValues);
        db.close();
        return true;

    }

    public boolean updateItems (String username, String password) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        db.update("account", contentValues, " username = ? ", new String[] {username});
        return true;

    }

    public Integer deleteproduct (String username)  {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("account", " username = ? ", new String[] {username});
    }

    public Cursor viewallProduct() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery(" select * from account", null);
        return  res;
    }

    public List<Logins> getUserLogins(String s, String toString) {
        SQLiteDatabase db= getWritableDatabase();

        List<Logins> list= new ArrayList<>();
        Cursor cursor =db.rawQuery(" select * from account" , null);
        Logins login = new Logins();

        if (cursor.moveToFirst()) {
            do {

                list.add(login=new Logins(Integer.parseInt(cursor.getString(0))
                        , cursor.getString(1),  cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5)
                        ,  cursor.getString(6)));
            } while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return list;
    }
}
