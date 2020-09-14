package com.example.pmdm02_tarefa.repositorios.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.pmdm02_tarefa.repositorios.entidades.DepartamentoProductos;
import com.example.pmdm02_tarefa.repositorios.entidades.Producto;

import java.util.List;

@Dao
public interface ProductoDAO {
    @Insert
    void insertar(Producto producto);
    @Query("SELECT * FROM producto")
    LiveData<List<Producto>> seleccionarTodos();
    @Query("DELETE FROM producto")
    public void eliminarTodos();
    @Query("SELECT * FROM Producto WHERE _id=:id")
    Producto getPorId(long id);
    @Query("SELECT * FROM Producto WHERE descricion_producto = :desc")
    Producto getPorDesc(String desc);
    @Query("SELECT * FROM departamento")
    List<DepartamentoProductos> getTodosDepartamentos();

}
