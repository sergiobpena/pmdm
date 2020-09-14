package com.example.pmdm02_tarefa.repositorios;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.pmdm02_tarefa.repositorios.daos.DepartamentoDAO;
import com.example.pmdm02_tarefa.repositorios.daos.ProductoDAO;
import com.example.pmdm02_tarefa.repositorios.entidades.Departamento;
import com.example.pmdm02_tarefa.repositorios.entidades.Producto;

import java.util.List;

public class ProductosRepositorio {
    private ProductoDAO productoDAO;
    private DepartamentoDAO departamentoDAO;
    private LiveData<List<Producto>> productos;
    private LiveData<List<Departamento>> departamentos;
    public ProductosRepositorio(Application application){
        BDTenda bd=BDTenda.getBD(application);
        this.productoDAO=bd.productoDAO();
        productos= productoDAO.seleccionarTodos();
        departamentoDAO=bd.departamentoDAO();
        departamentos= departamentoDAO.dameTodos();
    }
    public LiveData<List<Producto>> getProductos(){return productos;}
    public LiveData<List<Departamento>> getDepartamentos(){return departamentos;}
}
