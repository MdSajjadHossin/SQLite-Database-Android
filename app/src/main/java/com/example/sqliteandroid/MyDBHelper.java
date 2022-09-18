package com.example.sqliteandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "contactDB";
    private static final int VERSION_ID = 1;
    private static final String TABLE_NAME = "contacts";
    private static final String  KEY_ID = "id";
    private static final String  KEY_NAME = "name";
    private static final String  KEY_PHONE_NO = "phone_no";


    public MyDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION_ID);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + "TEXT" + KEY_PHONE_NO + "TEXT" + ")" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
}
