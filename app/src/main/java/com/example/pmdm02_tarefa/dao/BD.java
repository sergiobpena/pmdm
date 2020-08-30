package com.example.pmdm02_tarefa.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BD extends SQLiteOpenHelper {
    public final static String NOME_BD="TENDA_ANROID";
    public final static int VERSION_BD=1;

    public BD (Context context) {
        super(context, NOME_BD, null, VERSION_BD);
        // TODO Auto-generated constructor stub
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
