package com.example.pmdm02_tarefa.repositorios.entidades;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class DepartamentoProductos {
    @Embedded
    public Departamento departamento;
    @Relation(parentColumn = "_id",entityColumn = "fk_departamento")
    public List<Producto> productos;
}
