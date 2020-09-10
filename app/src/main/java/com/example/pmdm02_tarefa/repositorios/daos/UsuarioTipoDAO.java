package com.example.pmdm02_tarefa.repositorios;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UsuarioTipoDAO {
    @Query("SELECT * FROM usuarioTipo")
    public UsuarioTipo tipos();
    @Query("SELECT * FROM usuarioTipo WHERE _id = :id")
    public UsuarioTipo tipoId(long id);
    @Insert
    public void insertarTipo(UsuarioTipo usuarioTipo);
}
