package com.example.pmdm02_tarefa.repositorios.entidades;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class UsuariosDireccion {
    @Embedded
    public Usuario usuario;
    @Relation(parentColumn = "_id",entityColumn = "fk_usuario")
    public List<Direccion> direccions ;

}
