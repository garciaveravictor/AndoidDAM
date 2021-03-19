package com.example.basesdedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DiscotecaDB miDiscoteca = new DiscotecaDB(this, "Discoteca.db", null, 1);

        SQLiteDatabase bd = miDiscoteca.getWritableDatabase();

        if(bd != null){

        }

        bd.close();
    }
}