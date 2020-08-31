package com.example.pmdm02_tarefa.dao.contract;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class ProductoTaboa implements BaseColumns , ContratoEntidade {
    public static final String TABLE_NAME="PRODUCTO";
    public static final String COLUMN_NAME_DEPARTAMENTO="departamento";
    public static final String COLUMN_NAME_NOME="nome";
    public static final String COLUMN_NAME_PREZO="prezo";
    private final String CREAR_TABOA="CREATE TABLE " + TABLE_NAME + "(" +
            _ID +" INTEGER PRIMARY KEY ," +
            COLUMN_NAME_DEPARTAMENTO + " INTEGER NOT NULL , " +
            COLUMN_NAME_NOME + " VARCHAR(50) NOT NULL , " +
            COLUMN_NAME_PREZO + "  NUMBER(10,2) NOT NULL ," +
            "FOREIGN KEY ("+COLUMN_NAME_DEPARTAMENTO + ") REFERENCES "+DepartamentoTaboa.TABLE_NAME +"" +
            "("+DepartamentoTaboa._ID +") ON DELETE SET NULL ON UPDATE CASCADE)";
    private final String ELIMINAR_TABOA="DROP TABLE "+TABLE_NAME;
    @Override
    public void seed(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void crearTaboa(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREAR_TABOA);
    }

    @Override
    public void eliminarTaboa(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(ELIMINAR_TABOA);
    }
}
