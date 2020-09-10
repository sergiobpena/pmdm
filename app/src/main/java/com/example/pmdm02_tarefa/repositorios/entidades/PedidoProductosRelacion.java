package com.example.pmdm02_tarefa.repositorios.entidades;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class PedidoProductosRelacion {
    @Embedded
    public Pedido pedido;
    @Relation(parentColumn = "_id",entityColumn = "_id",associateBy = @Junction( ProductosPedidos.class))
    public List<Producto> productos;
}
