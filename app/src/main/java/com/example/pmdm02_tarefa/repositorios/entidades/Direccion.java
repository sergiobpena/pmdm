package com.example.pmdm02_tarefa.repositorios.entidades;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Direccion {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private long _id;
    private String direccion;
    private String cidade;
    private int cod_postal;
    @NonNull
    private long fk_usuario;
    public Direccion(){}
    public Direccion(long _id, String direccion, String cidade, int cod_postal, @NonNull Usuario fk_usuario) {
        this._id = _id;
        this.direccion = direccion;
        this.cidade = cidade;
        this.cod_postal = cod_postal;
        this.fk_usuario = fk_usuario.get_id();
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getCod_postal() {
        return cod_postal;
    }

    public void setCod_postal(int cod_postal) {
        this.cod_postal = cod_postal;
    }

    public long getFk_usuario() {
        return fk_usuario;
    }

    public void setFk_usuario(long fk_usuario) {
        this.fk_usuario = fk_usuario;
    }
    public void setFk_usuario(Usuario usuario){
        this.fk_usuario=usuario.get_id();
    }

    @Override
    public String toString() {
        return
                "Direccion='" + direccion + '\'' +
                ", Cidade='" + cidade + '\'' +
                ", CP=" + cod_postal ;
    }
}
