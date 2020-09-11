package com.example.pmdm02_tarefa.repositorios;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.pmdm02_tarefa.repositorios.daos.UsuarioDao;
import com.example.pmdm02_tarefa.repositorios.daos.UsuarioTipoDAO;
import com.example.pmdm02_tarefa.repositorios.entidades.Usuario;
import com.example.pmdm02_tarefa.repositorios.entidades.UsuarioTipo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Usuario.class, UsuarioTipo.class}, version = 1, exportSchema = false)
public abstract class BDTenda extends RoomDatabase {
    public abstract UsuarioDao usuarioDao();
    public abstract UsuarioTipoDAO usuarioTipoDAO();
    private static volatile BDTenda BD;
    private static final int NUM_THREADS=4;
    public static final ExecutorService dbWriteExecutor= Executors.newFixedThreadPool(NUM_THREADS);
    public static BDTenda getBD(final Context context){
        if(BD == null){
            synchronized (BDTenda.class){
                if(BD ==null){
                    BD= Room.databaseBuilder(context.getApplicationContext(),
                            BDTenda.class,"bd_tenda").addCallback(bdCallback).allowMainThreadQueries().build();
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
