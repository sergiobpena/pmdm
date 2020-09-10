package com.example.pmdm02_tarefa.repositorios.entidades;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "usuarioTipo")
public class UsuarioTipo {
    @PrimaryKey
    @NonNull
    private long _id;
    @ColumnInfo(name = "descricion")
    private String tipo;
    public UsuarioTipo(String tipo,long id){
        this._id=id;
        this.tipo=tipo;
    }
    public UsuarioTipo(){}

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String toString(){
        return this.tipo;
    }
}
