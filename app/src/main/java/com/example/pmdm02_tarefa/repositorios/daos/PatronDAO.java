package com.example.pmdm02_tarefa.repositorios.daos;

import java.util.List;

public interface PatronDAO<T> {
    void insertar(T t);
    void eliminarTodos();
    List<T> seleccionarTodos();
    T getPorId(long id);
    T getPorDesc(String desc);
}
