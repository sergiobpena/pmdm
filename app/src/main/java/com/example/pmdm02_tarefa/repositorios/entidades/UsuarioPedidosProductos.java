package com.example.pmdm02_tarefa.repositorios.entidades;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class UsuarioPedidosProductos {
    @Embedded
    Usuario usuario;
    @Relation(parentColumn = "_id",entityColumn = "fk_usuario",associateBy = @Junction(PedidoProductosRelacion.class))
    List<PedidoProductosRelacion> pedidosUsuario;
}
