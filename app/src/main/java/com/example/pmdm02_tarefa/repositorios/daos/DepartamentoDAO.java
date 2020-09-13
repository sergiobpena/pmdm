package com.example.pmdm02_tarefa.repositorios.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.pmdm02_tarefa.repositorios.entidades.Departamento;

import java.util.List;

@Dao
public interface DepartamentoDAO {
    @Query("DELETE FROM departamento")
    public void eliminarTodos();
    @Insert
    public void insertar(Departamento departamento);
    @Query("SELECT * FROM Departamento")
    public List<Departamento> dameTodos();
    @Query("SELECT * FROM DEPARTAMENTO WHERE descricion=:desc")
    public Departamento dameUn(String desc);
}
