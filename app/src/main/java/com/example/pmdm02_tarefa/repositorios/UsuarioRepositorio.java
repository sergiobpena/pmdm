package com.example.pmdm02_tarefa.repositorios;

import android.app.Application;

import com.example.pmdm02_tarefa.repositorios.daos.UsuarioDao;
import com.example.pmdm02_tarefa.repositorios.daos.UsuarioTipoDAO;
import com.example.pmdm02_tarefa.repositorios.entidades.Usuario;
import com.example.pmdm02_tarefa.repositorios.entidades.UsuarioTipo;

import java.util.List;

public class UsuarioRepositorio {
    private UsuarioDao usuarioDao;
    private UsuarioTipoDAO usuarioTipoDAO;
    private Usuario usuario;

    public UsuarioRepositorio(Application application){
        BDTenda bdTenda= BDTenda.getBD(application);
        usuarioDao=bdTenda.usuarioDao();
        usuarioTipoDAO=bdTenda.usuarioTipoDAO();
    }
    public Usuario dameUsuario(Usuario usuario){
        return usuarioDao.getUsuario(usuario.getUsuario());
    }
    public UsuarioTipo dameTipo(long id_tipo){
        return usuarioTipoDAO.tipoId(id_tipo);
    }

    public Usuario dameUsuarioUser(String user) { return usuarioDao.dameUserUser(user);
    }

    public List<UsuarioTipo> dameTipos() {
        return  usuarioTipoDAO.tipos();
    }

    public void insertar(Usuario usuario) {
        usuarioDao.insertarUsuario(usuario);
    }
}
