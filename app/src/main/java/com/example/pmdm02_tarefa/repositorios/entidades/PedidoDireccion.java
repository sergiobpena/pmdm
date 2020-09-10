package com.example.pmdm02_tarefa.repositorios.entidades;

import androidx.room.Embedded;
import androidx.room.Relation;

public class PedidoDireccion {
    @Embedded
    @Relation(parentColumn = "_id",entityColumn = "fk_direccion")
    public Pedido pedido;
}
