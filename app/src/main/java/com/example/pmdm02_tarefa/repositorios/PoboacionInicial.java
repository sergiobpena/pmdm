package com.example.pmdm02_tarefa.repositorios;

import android.os.AsyncTask;
import android.util.Log;

import com.example.pmdm02_tarefa.repositorios.entidades.Departamento;
import com.example.pmdm02_tarefa.repositorios.entidades.Direccion;
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
        Direccion direccion= new Direccion(1L,"Travesia Andazo 15","Compistola",
                15666,usuarios[0]);

        Departamento[] departamentos={
                new Departamento(1L,"Informática"),
                new Departamento(2L,"Telefonia"),
                new Departamento(3L,"Electronica")
        };


        return null;
    }
}
