package com.example.sqliteandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDBHelper dbHelper = new MyDBHelper(this);

        dbHelper.addContact("Md Sajjad Hossin", "01790561194");
        dbHelper.addContact("Md Sajid Hossain", "01790561195");
        dbHelper.addContact("Md Asif Iqueball", "01790561196");
        dbHelper.addContact("Md Maruful Islam", "01790561197");
        dbHelper.addContact("Md Tanvir Rahman", "017905611948");
        dbHelper.addContact("Md Fahim Ahmed", "01790561199");

    }
}