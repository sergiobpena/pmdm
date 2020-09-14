package com.example.pmdm02_tarefa.repositorios.entidades;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(primaryKeys ={"fk_pedido","fk_producto"})
public class ProductosPedidos {
    private long fk_pedido;
    private long fk_producto;
    @NonNull
    private int cantidade;

    public ProductosPedidos(){}

    public ProductosPedidos(long fk_pedido, long fk_producto, int cantidade) {
        this.fk_pedido = fk_pedido;
        this.fk_producto = fk_producto;
        this.cantidade = cantidade;
    }

    public long getFk_pedido() {
        return fk_pedido;
    }

    public void setFk_pedido(long fk_pedido) {
        this.fk_pedido = fk_pedido;
    }

    public long getFk_producto() {
        return fk_producto;
    }

    public void setFk_producto(long fk_producto) {
        this.fk_producto = fk_producto;
    }

    public int getCantidade() {
        return cantidade;
    }

    public void setCantidade(int cantidade) {
        this.cantidade = cantidade;
    }
}
