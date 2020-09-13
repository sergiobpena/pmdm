package com.example.pmdm02_tarefa.repositorios.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.pmdm02_tarefa.repositorios.entidades.Pedido;

import java.util.List;

@Dao
public interface PedidoDAO {
    @Insert
    void insertar(Pedido p);
    @Query("DELETE FROM pedido")
    void eliminarTodo();
    @Query("SELECT * FROM pedido")
    List<Pedido> seleccionarTodos();
}
