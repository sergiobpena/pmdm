package com.example.pmdm02_tarefa.repositorios.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.pmdm02_tarefa.repositorios.entidades.Usuario;

@Dao
public interface UsuarioDao {
    @Query("SELECT * FROM usuarios where usuario = :usuario")
    public Usuario getUsuario(String usuario);
    @Insert
    public void insertarUsuario(Usuario usuario);
    @Query("SELECT * FROM usuarios where usuario = :user")
    Usuario dameUserUser(String user);
}
