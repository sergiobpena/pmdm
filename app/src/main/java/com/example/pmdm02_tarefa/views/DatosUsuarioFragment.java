package com.example.pmdm02_tarefa.views;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pmdm02_tarefa.R;
import com.example.pmdm02_tarefa.repositorios.entidades.Usuario;
import com.example.pmdm02_tarefa.viewModels.DatosUsuarioViewModel;

public class DatosUsuarioFragment extends Fragment {

//    private DatosUsuarioViewModel mViewModel;
    private static Usuario usuario;

    public static DatosUsuarioFragment newInstance(Usuario usuariox) {
        usuario=usuariox;
        return new DatosUsuarioFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View rootView= inflater.inflate(R.layout.datos_usuario_fragment, container, false);
        TextView nome=rootView.findViewById(R.id.usuario_nome);
        nome.setText(usuario.getNome());
        TextView ap1=rootView.findViewById(R.id.usuario_ap1);
        TextView ap2=rootView.findViewById(R.id.usuario_ap2);
        ap1.setText(usuario.getApelido1());
        ap2.setText(usuario.getApelido2());
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

}