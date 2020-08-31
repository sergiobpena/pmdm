package com.example.pmdm02_tarefa.dao.contract;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.example.pmdm02_tarefa.dao.dto.Producto;

import java.util.List;

public class DepartamentoTaboa implements BaseColumns , ContratoEntidade{
    public static final String TABLE_NAME="Departamento";
    public static final String COLUMN_NAME_DESCRICION="descricion";

    private final String CREAR_TABOA="CREATE TABLE " + TABLE_NAME + "(" +
            _ID + "INTEGER  PRIMARY KEY AUTOINCREMENT," +
            COLUMN_NAME_DESCRICION +" VARCHAR (50) NOT NULL);";

    private final String ELIMINAR_TABOA="DROP TABLE " + TABLE_NAME +";";

    public void crearTaboa(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(CREAR_TABOA);
    }

    @Override
    public void eliminarTaboa(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(ELIMINAR_TABOA);
    }

    public void seed(SQLiteDatabase sqLiteDatabase){
        String[] departamentos={"Informática", "Electronica", "Moviles"};
        for(String s : departamentos){
            ContentValues values=new ContentValues();
            values.put(COLUMN_NAME_DESCRICION,s);
            sqLiteDatabase.insert(TABLE_NAME,null,values);
        }
    }
}
