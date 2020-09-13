package com.example.pmdm02_tarefa.repositorios.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.pmdm02_tarefa.repositorios.entidades.Estados;

import java.util.List;

@Dao
public interface EstadoDAO {
    @Insert
    void insertar(Estados e);
    @Query("DELETE FROM estados")
    void eliminarTodos();
    @Query("SELECT * FROM estados")
    List<Estados> seleccionarTodos();

}
