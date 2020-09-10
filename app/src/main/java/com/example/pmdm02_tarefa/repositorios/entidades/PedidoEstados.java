package com.example.pmdm02_tarefa.repositorios.entidades;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import java.util.List;


public class PedidoEstados {
    @Embedded
    public Estados estados;
    @Relation(parentColumn = "_id",entityColumn = "fk_estado")
    public List<Pedido> pedidos;
}
