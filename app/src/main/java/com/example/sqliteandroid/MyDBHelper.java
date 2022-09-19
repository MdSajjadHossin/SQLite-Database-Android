package com.example.sqliteandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

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

        SQLiteDatabase dataBase = this.getWritableDatabase();

        dataBase.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public void addContact(String name, String phone_no){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_PHONE_NO, phone_no);


        db.insert(TABLE_NAME, null, values);
    }

    public ArrayList<ContactModel> fetchContact(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME, null);

        ArrayList<ContactModel> arrayContacts = new ArrayList<>();

        while (cursor.moveToNext()){

            ContactModel model = new ContactModel();
            model.id = cursor.getInt(0);
            model.name = cursor.getString(1);
            model.phone_number = cursor.getString(2);

            arrayContacts.add(model);

        }
        return arrayContacts;

    }
}
