package com.example.pmdm02_tarefa.dao.contract;

import android.database.sqlite.SQLiteDatabase;

public interface ContratoEntidade {
    void seed(SQLiteDatabase sqLiteDatabase);
    void crearTaboa(SQLiteDatabase sqLiteDatabase);
    void eliminarTaboa(SQLiteDatabase sqLiteDatabase);
}
