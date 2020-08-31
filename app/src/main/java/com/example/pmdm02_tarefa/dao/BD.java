package com.example.pmdm02_tarefa.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BD extends SQLiteOpenHelper {

    public final static String NOME_BD="base_datos_tenda";
    public final static int VERSION_BD=1;
    private SQLiteDatabase sqLiteDatabase;
    private static BD sInstance;
    

    public static synchronized BD getInstance(Context context){
        if (sInstance == null){
            sInstance=new BD(context.getApplicationContext());
        }
        return sInstance;
    }
    public BD (Context context) {
        super(context, NOME_BD, null, VERSION_BD);
        // TODO Auto-generated constructor stub
    }

    private void copiarBD(Context context){
        String bddestino="/data/data/" + context.getPackageName() + "/databases/" + NOME_BD;
        File file = new File(bddestino);
        if (file.exists()){
            return;
        }
        String pathbd="/data/data/" + context.getPackageName() + "/databases";
        File filePathdb=new File(pathbd);
        filePathdb.mkdirs();
        InputStream inputStream;
        try {
            inputStream=context.getAssets().open(NOME_BD);
            OutputStream outputStream= new FileOutputStream(bddestino);
            int tamread;
            byte[] buffer= new byte[2048];
            while ((tamread=inputStream.read(buffer))>0){
                outputStream.write(buffer,0,tamread);
            }
            inputStream.close();
            outputStream.flush();
            outputStream.close();
        }catch (IOException e ){
            e.printStackTrace();
        }
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
