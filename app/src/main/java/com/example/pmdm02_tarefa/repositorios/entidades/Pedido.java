package com.example.pmdm02_tarefa.repositorios.entidades;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Pedido {
    @PrimaryKey(autoGenerate = true)
    private long _id;
    private Date data;
    @NonNull
    private long fk_estado;
    @NonNull
    private long fk_usuario;
    @NonNull
    private long fk_direccion;

    public Pedido(long _id, Date data, Estados fk_estado, Usuario fk_usuario, Direccion fk_direccion) {
        this._id = _id;
        this.data = data;
        this.fk_estado = fk_estado.get_id();
        this.fk_usuario = fk_usuario.get_id();
        this.fk_direccion = fk_direccion.get_id();
    }

    public Pedido(){}

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public long getFk_estado() {
        return fk_estado;
    }

    public void setFk_estado(long fk_estado) {
        this.fk_estado = fk_estado;
    }

    public long getFk_usuario() {
        return fk_usuario;
    }

    public void setFk_usuario(long fk_usuario) {
        this.fk_usuario = fk_usuario;
    }

    public long getFk_direccion() {
        return fk_direccion;
    }

    public void setFk_direccion(long fk_direccion) {
        this.fk_direccion = fk_direccion;
    }
}
