package com.example.pmdm02_tarefa.repositorios.entidades;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.pmdm02_tarefa.repositorios.entidades.Usuario;
import com.example.pmdm02_tarefa.repositorios.entidades.UsuarioTipo;

import java.util.List;

public class UsuariosUsuariosTipo {
    @Embedded
    public UsuarioTipo usuarioTipo;
    @Relation(parentColumn = "_id",entityColumn = "usuarioTipo")
    public List<Usuario> usuarios;
}
