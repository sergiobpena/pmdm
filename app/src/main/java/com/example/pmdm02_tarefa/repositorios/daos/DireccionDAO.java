package com.example.pmdm02_tarefa.repositorios.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.pmdm02_tarefa.repositorios.entidades.Direccion;

import java.util.List;

@Dao
public interface DireccionDAO {
    @Insert
    void insertar(Direccion d);
    @Query("DELETE FROM direccion")
    void eliminarTodos();
    @Query("SELECT * FROM DIRECCION")
    List<Direccion> seleccionarTodos();

    @Query("SELECT * FROM direccion WHERE _id = :id ")
    Direccion getPorId(long id);

}
