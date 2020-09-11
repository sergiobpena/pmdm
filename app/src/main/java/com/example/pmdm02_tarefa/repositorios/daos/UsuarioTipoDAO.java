package com.example.pmdm02_tarefa.repositorios.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.pmdm02_tarefa.repositorios.entidades.Departamento;
import com.example.pmdm02_tarefa.repositorios.entidades.UsuarioTipo;

import java.util.List;

@Dao
public interface UsuarioTipoDAO {
    @Query("SELECT * FROM usuarioTipo")
    public List<UsuarioTipo> tipos();
    @Query("SELECT * FROM usuarioTipo WHERE _id = :id")
    public UsuarioTipo tipoId(long id);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertarTipo(UsuarioTipo usuarioTipo);
//    @Query("SELECT * FROM departamento")
//    public Departamento[] departamentos();
}
