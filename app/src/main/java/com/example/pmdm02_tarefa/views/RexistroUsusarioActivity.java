package com.example.pmdm02_tarefa.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pmdm02_tarefa.MainActivity;
import com.example.pmdm02_tarefa.R;
import com.example.pmdm02_tarefa.repositorios.entidades.Usuario;
import com.example.pmdm02_tarefa.repositorios.entidades.UsuarioTipo;
import com.example.pmdm02_tarefa.viewModels.LoginViewModel;

import java.util.List;

public class RexistroUsusarioActivity extends AppCompatActivity {
    TextView txtUsuario;
    TextView txtNome;
    TextView txtAp1;
    TextView txtAp2;
    TextView txtCorreo;
    TextView txtContrasinal;
    Spinner categoria;
    LoginViewModel loginViewModel;
    List<UsuarioTipo> usuarioTipos;
    ArrayAdapter<UsuarioTipo> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rexistro_ususario);
        loginViewModel=new ViewModelProvider(this).get(LoginViewModel.class);
        usuarioTipos=loginViewModel.dameTiposUsuario();
        cargaElementos();
        cargaTiposU();
        cargarEventos();
    }
//    public Usuario(String nome, String usuario, String pass, String apelido1, String apelido2, String correoe, UsuarioTipo usuarioTipo )
    public Usuario creaUsuario(){
        Usuario usuario= new Usuario(
                txtNome.getText().toString(),
                txtUsuario.getText().toString(),
                txtContrasinal.getText().toString(),
                txtAp1.getText().toString(),
                txtAp2.getText().toString(),
                txtCorreo.getText().toString(),
                (UsuarioTipo)categoria.getSelectedItem()
                //Falta o tipo de usuario.
        );
        return usuario;
    }

    private void cargarEventos(){
        Button btnSair=findViewById(R.id.btn_rexistro_cancelar);
        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(loginIntent);
                finish();
            }
        });

        Button btnAceptar=findViewById(R.id.btn_rexistro_aceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario=creaUsuario();
                if(valida()){
                    if(loginViewModel.dameUsuario(usuario)==null){
                        //rexistra
                        loginViewModel.insertarUsuario(usuario);
                        Intent intentUsuario= new Intent(getApplicationContext(),UsuatioActivity.class);
                        intentUsuario.putExtra(MainActivity.NOME,usuario.getUsuario());
                        startActivity(intentUsuario);
                        Toast.makeText(getApplicationContext(),"Usuario Rexistrado",Toast.LENGTH_LONG).show();
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(),"Machiño , O usuario xa existe",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Machiño , hai que cubrir usuario ou contrasinal",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void cargaTiposU(){
        adapter=new ArrayAdapter<UsuarioTipo>(this,R.layout.support_simple_spinner_dropdown_item,usuarioTipos);
        categoria.setAdapter(adapter);
        Log.i("Tipo de usuario",""+usuarioTipos.size());
    }
    public void cargaElementos(){
        txtUsuario=findViewById(R.id.rexistro_usuario);
        txtNome=findViewById(R.id.rexistro_nome);
        txtAp1=findViewById(R.id.rexistro_ap1);
        txtAp2=findViewById(R.id.rexistro_ap2);
        txtCorreo=findViewById(R.id.rexistro_correo);
        txtContrasinal=findViewById(R.id.rexistro_txtContrasinal);
        categoria=findViewById(R.id.rexistro_sp_tipoU);
    }
    public boolean valida(){
        if(txtUsuario.getText().toString() == null || txtUsuario.getText().toString().equals("")) return false;
        if(txtContrasinal.getText().toString() == null || txtContrasinal.getText().toString().equals("")) return false;
        return true;
    }
}