package com.example.pmdm02_tarefa.repositorios;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.pmdm02_tarefa.repositorios.daos.DepartamentoDAO;
import com.example.pmdm02_tarefa.repositorios.daos.DireccionDAO;
import com.example.pmdm02_tarefa.repositorios.daos.EstadoDAO;
import com.example.pmdm02_tarefa.repositorios.daos.PedidoDAO;
import com.example.pmdm02_tarefa.repositorios.daos.ProductoDAO;
import com.example.pmdm02_tarefa.repositorios.daos.UsuarioDao;
import com.example.pmdm02_tarefa.repositorios.daos.UsuarioTipoDAO;
import com.example.pmdm02_tarefa.repositorios.entidades.Departamento;
import com.example.pmdm02_tarefa.repositorios.entidades.Direccion;
import com.example.pmdm02_tarefa.repositorios.entidades.Estados;
import com.example.pmdm02_tarefa.repositorios.entidades.Pedido;
import com.example.pmdm02_tarefa.repositorios.entidades.Producto;
import com.example.pmdm02_tarefa.repositorios.entidades.ProductosPedidos;
import com.example.pmdm02_tarefa.repositorios.entidades.Usuario;
import com.example.pmdm02_tarefa.repositorios.entidades.UsuarioTipo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Usuario.class, UsuarioTipo.class, Departamento.class,
        Direccion.class, Estados.class, Pedido.class,Producto.class, ProductosPedidos.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class BDTenda extends RoomDatabase {
    public abstract UsuarioDao usuarioDao();
    public abstract UsuarioTipoDAO usuarioTipoDAO();
    public abstract DepartamentoDAO departamentoDAO();
    public abstract PedidoDAO pedidoDAO();
    public abstract ProductoDAO productoDAO();
    public abstract EstadoDAO estadoDAO();
    public abstract DireccionDAO direccionDAO();

    private static volatile BDTenda BD;
    private static final int NUM_THREADS=4;
    public static final ExecutorService dbWriteExecutor= Executors.newFixedThreadPool(NUM_THREADS);
    public static BDTenda getBD(final Context context){
        if(BD == null){
            synchronized (BDTenda.class){
                if(BD ==null){
                    BD= Room.databaseBuilder(context.getApplicationContext(),
                            BDTenda.class,"bd_tenda_sqlite").addCallback(bdCallback).allowMainThreadQueries().build();
//                            BDTenda.class,"bd_tenda_final_x").allowMainThreadQueries().build();
                }
            }
        }
        return BD;
    }
    private static RoomDatabase.Callback bdCallback=new RoomDatabase.Callback(){
        public void onOpen(@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
            new PoboacionInicial(BD).execute();
        }
    };
}
