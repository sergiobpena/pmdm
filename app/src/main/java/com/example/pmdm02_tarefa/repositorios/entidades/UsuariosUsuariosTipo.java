package com.example.pmdm02_tarefa.repositorios;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class UsuariosUsuariosTipo {
    @Embedded
    public UsuarioTipo usuarioTipo;
    @Relation(parentColumn = "_id",entityColumn = "usuarioTipo")
    public List<Usuario> usuarios;
}
