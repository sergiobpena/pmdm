package com.example.pmdm02_tarefa.repositorios.entidades;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Estados {
    @PrimaryKey(autoGenerate = true)
    private long _id;
    @NonNull
    private String descricion;

    public Estados(long _id, @NonNull String descricion) {
        this._id = _id;
        this.descricion = descricion;
    }
    public Estados(){}

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    @NonNull
    public String getDescricion() {
        return descricion;
    }

    public void setDescricion(@NonNull String descricion) {
        this.descricion = descricion;
    }

    @Override
    public String toString() {
        return descricion;
    }
}
