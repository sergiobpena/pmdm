package com.example.pmdm02_tarefa.repositorios.entidades;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Producto {
    @PrimaryKey(autoGenerate = true)
    private long _id;
    private String nome_producto;
    private String descricion_producto;
    @NonNull
    private long fk_departamento;

    public Producto(long _id, String nome_producto, String descricion_producto, Departamento fk_departamento) {
        this._id = _id;
        this.nome_producto = nome_producto;
        this.descricion_producto = descricion_producto;
        this.fk_departamento = fk_departamento.get_id();
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getNome_producto() {
        return nome_producto;
    }

    public void setNome_producto(String nome_producto) {
        this.nome_producto = nome_producto;
    }

    public String getDescricion_producto() {
        return descricion_producto;
    }

    public void setDescricion_producto(String descricion_producto) {
        this.descricion_producto = descricion_producto;
    }

    public long getFk_departamento() {
        return fk_departamento;
    }

    public void setFk_departamento(long fk_departamento) {
        this.fk_departamento = fk_departamento;
    }

    @Override
    public String toString() {
        return nome_producto;
    }
}
