package com.example.pmdm02_tarefa.repositorios;

import android.os.AsyncTask;
import android.util.Log;

import com.example.pmdm02_tarefa.repositorios.entidades.Departamento;
import com.example.pmdm02_tarefa.repositorios.entidades.Direccion;
import com.example.pmdm02_tarefa.repositorios.entidades.Estados;
import com.example.pmdm02_tarefa.repositorios.entidades.Pedido;
import com.example.pmdm02_tarefa.repositorios.entidades.PedidoProductosRelacion;
import com.example.pmdm02_tarefa.repositorios.entidades.Producto;
import com.example.pmdm02_tarefa.repositorios.entidades.ProductosPedidos;
import com.example.pmdm02_tarefa.repositorios.entidades.Usuario;
import com.example.pmdm02_tarefa.repositorios.entidades.UsuarioTipo;

public class PoboacionInicial extends AsyncTask<Void,Void,Void> {
    private BDTenda bdTenda;

    public PoboacionInicial(BDTenda bd){
        bdTenda=bd;
    }
    @Override
    protected Void doInBackground(Void... voids) {
        Log.i("Poboando","OK");
        UsuarioTipo[] usuarioTipos={
                new UsuarioTipo("admin",1L),
                new UsuarioTipo("user",2L)
        };
        for (UsuarioTipo x : usuarioTipos){
            bdTenda.usuarioTipoDAO().insertarTipo(x);
        }

        Usuario[] usuarios= {
                new Usuario(1L,"Sergio","sergio","abc123.","Botana","Pena","h@p.com",usuarioTipos[1]),
                new Usuario(2L,"Felipe","admin","abc123.","Santaluce","Carrillo","a@b.com",usuarioTipos[0])
        };

        for (Usuario u : usuarios){
            bdTenda.usuarioDao().insertarUsuario(u);
        }
        Direccion[] direccion= {
                new Direccion(1L, "Travesia Andazo 15", "Compistola",
                15666, usuarios[0]),
                new Direccion(2L,"Carallo","Lala",15690,usuarios[1]),
        };

        for(Direccion d : direccion){
            bdTenda.direccionDAO().insertar(d);
        }

        Departamento[] departamentos={
                new Departamento(1L,"Informática"),
                new Departamento(2L,"Telefonia"),
                new Departamento(3L,"Electronica")
        };
        for (Departamento d : departamentos){
            bdTenda.departamentoDAO().insertar(d);
        }
        Producto[] productos={
          new Producto(1L,"Xiaomi","Telefono guai",departamentos[1],200),
          new Producto(2L,"Pixel","Movil Pixel",departamentos[1],150),
          new Producto(3L,"Samsung","Ladrillo",departamentos[1],1000),
          new Producto(4L,"Portatil","Lenovo",departamentos[0],1500),
          new Producto(5L,"Disco duro","SSD",departamentos[0],150),
          new Producto(6L,"Television","LCD",departamentos[2],350),
          new Producto(7L,"Licuadora","Licuadora blabla",departamentos[2],150)
        };
        for (Producto p : productos){
            bdTenda.productoDAO().insertar(p);
        }
        Estados[] estados={
                new Estados(1L,"En tramite"),
                new Estados(2L,"Aceptado"),
                new Estados(3L,"Rexeitado")
        };
        for (Estados e : estados){
            bdTenda.estadoDAO().insertar(e);
        }

        Pedido[] pedidos={
          new Pedido(1L,null,estados[0],usuarios[0],direccion[0]),
          new Pedido(2L,null,estados[1],usuarios[0],direccion[0])
        };
        for (Pedido p : pedidos){
            bdTenda.pedidoDAO().insertar(p);
        }


        return null;
    }
}
