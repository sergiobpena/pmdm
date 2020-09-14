package com.example.pmdm02_tarefa.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.pmdm02_tarefa.repositorios.ProductosRepositorio;
import com.example.pmdm02_tarefa.repositorios.entidades.Departamento;
import com.example.pmdm02_tarefa.repositorios.entidades.Producto;

import java.util.List;

public class ProductosViewModel extends AndroidViewModel {
    private ProductosRepositorio productosRepositorio;
    private LiveData<List<Producto>> productos;
    private LiveData<List<Departamento>> departamentos;
    public ProductosViewModel(@NonNull Application application) {
        super(application);
        this.productosRepositorio=new ProductosRepositorio(application);
        this.productos=productosRepositorio.getProductos();
        this.departamentos=productosRepositorio.getDepartamentos();
    }

    public LiveData<List<Producto>> getProductos(){return productos;}
    public LiveData<List<Departamento>> getDepartamentos(){return departamentos;}
}
