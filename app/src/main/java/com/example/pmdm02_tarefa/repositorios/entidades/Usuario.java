package com.example.pmdm02_tarefa.repositorios.entidades;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "usuarios",
        indices = {@Index(value = {"usuario"}, unique = true)})
public class Usuario {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private long _id;
    private String nome;
    private String usuario;
    private String pass;
    private String apelido1;
    private String apelido2;
    private String correoe;
    private long usuarioTipo;

    public Usuario(String nome, String usuario, String pass, String apelido1, String apelido2,String correoe,UsuarioTipo usuarioTipo ){
        this.nome = nome;
        this.usuario = usuario;
        this.pass = pass;
        this.apelido1 = apelido1;
        this.apelido2 = apelido2;
        this.correoe=correoe;
        this.usuarioTipo=usuarioTipo.get_id();
    }

    public Usuario(@NonNull String usuario,@NonNull String pass) {
        this.usuario = usuario;
        this.pass = pass;
    }
    public Usuario(){}

    public Usuario(long l, String nome, String usuario, String pass, String apelido1, String apelido2,String correoe,UsuarioTipo usuarioTipo ) {
        this.nome = nome;
        this.usuario = usuario;
        this.pass = pass;
        this.apelido1 = apelido1;
        this.apelido2 = apelido2;
        this.correoe=correoe;
        this.usuarioTipo=usuarioTipo.get_id();
        this._id=l;

    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public long get_id() {
        return _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getApelido1() {
        return apelido1;
    }

    public void setApelido1(String apelido1) {
        this.apelido1 = apelido1;
    }

    public String getApelido2() {
        return apelido2;
    }

    public void setApelido2(String apelido2) {
        this.apelido2 = apelido2;
    }

    public String getCorreoe() {
        return correoe;
    }

    public void setCorreoe(String correoe) {
        this.correoe = correoe;
    }

    public long getUsuarioTipo() {
        return usuarioTipo;
    }

    public void setUsuarioTipo(long usuarioTipo) {
        this.usuarioTipo = usuarioTipo;
    }
}
