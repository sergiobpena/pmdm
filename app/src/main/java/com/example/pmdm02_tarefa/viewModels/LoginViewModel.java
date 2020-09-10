package com.example.pmdm02_tarefa.viewModels;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.pmdm02_tarefa.repositorios.entidades.Usuario;
import com.example.pmdm02_tarefa.repositorios.UsuarioRepositorio;

public class LoginViewModel extends AndroidViewModel {
    public static final int LOGIN_OK=1;
    public static final int LOGIN_ERR_USUARIO=0;
    public static final int LOGIN_ERR_CONT=2;
    private UsuarioRepositorio usuarioRepositorio;
    public LoginViewModel(@NonNull Application application) {
        super(application);
        usuarioRepositorio= new UsuarioRepositorio(application);
    }
    public int login(Usuario usuario){
        Usuario u=null ;
        try {
            u = usuarioRepositorio.dameUsuario(usuario);
            Log.i("Test BD","OK");
            Log.i("Test BD",u.getApelido1());
            Log.i("Test BD",u.getPass());
        } catch (Exception e){
            e.printStackTrace();

        }
//        String user=usuarioRepositorio.dameUsuario(usuario).getUsuario();
//        String pass=usuarioRepositorio.dameUsuario(usuario).getPass();
        if (u == null){
            return LOGIN_ERR_USUARIO;
        }else if(usuario.getPass().equals(u.getPass())){
            return LOGIN_OK;
        }
        return LOGIN_ERR_CONT;
    }
    public Usuario dameUsuario(Usuario usuario){
        return usuarioRepositorio.dameUsuario(usuario);
    }
    public String dameTipo(Usuario usuario){
        return usuarioRepositorio.dameTipo(usuario.getUsuarioTipo()).getTipo();
    }
    public Usuario dameUsuarioUser(String user){return usuarioRepositorio.dameUsuarioUser(user);}
}
