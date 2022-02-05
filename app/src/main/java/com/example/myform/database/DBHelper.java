package com.example.myform.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myform.model.Model;

public class DBHelper extends SQLiteOpenHelper {


    public static final String USER_TABLE = "USER_TABLE";
    public static final String COLUMN_USER_NAME = "USER_NAME";
    public static final String COLUMN_USER_PHONE = "USER_PHONE";
    public static final String COLUMN_USER_EMAIL = "USER_EMAIL";
    public static final String COLUMN_USER_BRANCH = "USER_BRANCH";
    public static final String COLUMN_USER_REG = "USER_REG";

    public DBHelper(@Nullable Context context) {
        super(context, "users.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE " + USER_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " " + COLUMN_USER_NAME + " TEXT," +
                " " + COLUMN_USER_PHONE + " TEXT," +
                COLUMN_USER_EMAIL + " TEXT," +
                COLUMN_USER_BRANCH + " TEXT," +
                COLUMN_USER_REG + " TEXT)";

        sqLiteDatabase.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean add(Model model){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_USER_NAME, model.getName());
        cv.put(COLUMN_USER_PHONE, model.getPhone());
        cv.put(COLUMN_USER_EMAIL, model.getEmail());
        cv.put(COLUMN_USER_BRANCH, model.getBranch());
        cv.put(COLUMN_USER_REG, model.getReg());

        long insert = db.insert(USER_TABLE, null, cv);
        if (insert == -1){
            return false;
        }else {
            return true;
        }

    }


    public Cursor ViewData(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT USER_NAME, USER_PHONE, USER_EMAIL, USER_BRANCH, USER_REG FROM USER_TABLE";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        return cursor;
    }



}
