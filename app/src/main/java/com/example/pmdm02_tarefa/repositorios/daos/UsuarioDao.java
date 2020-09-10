package com.example.pmdm02_tarefa.repositorios;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UsuarioDao {
    @Query("SELECT * FROM usuarios where usuario = :usuario")
    public Usuario getUsuario(String usuario);
    @Insert
    public void insertarUsuario(Usuario usuario);
}
