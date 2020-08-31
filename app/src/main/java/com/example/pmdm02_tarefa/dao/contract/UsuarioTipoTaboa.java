package com.example.pmdm02_tarefa.dao.contract;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class UsuarioTipoTaboa implements BaseColumns, ContratoEntidade {
    public static final String TABLE_NAME="USUARIO_TIPO";
    public static final String COLUMN_NAME_DESCRICION="descricion";
    private final String CREAR_TABOA="CREATE TABLE " + TABLE_NAME + "(" +
            _ID + "INTEGER PRIMARY KEY AUTOINCREMENT ," +
            COLUMN_NAME_DESCRICION + " VARCHAR(50) NOT NULL);";


    private final String BORRAR_TABOA="DROP TABLE " + TABLE_NAME;

    @Override
    public void seed(SQLiteDatabase sqLiteDatabase) {
        String[] valores={"usuario","administrador"};
        for (String s:valores){
            ContentValues values= new ContentValues();
            values.put(COLUMN_NAME_DESCRICION, s);
            sqLiteDatabase.insert(TABLE_NAME,null,values);
        }
    }

    @Override
    public void crearTaboa(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREAR_TABOA);

    }

    @Override
    public void eliminarTaboa(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(BORRAR_TABOA);
    }
}
