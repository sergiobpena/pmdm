package com.example.pmdm02_tarefa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pmdm02_tarefa.repositorios.entidades.Usuario;
import com.example.pmdm02_tarefa.viewModels.LoginViewModel;
import com.example.pmdm02_tarefa.views.AdminActiviti;
import com.example.pmdm02_tarefa.views.RexistroUsusarioActivity;
import com.example.pmdm02_tarefa.views.UsuatioActivity;

public class MainActivity extends AppCompatActivity {
    private final String USER_USUARIO="usuario";
    private final String PASS_USUARIO="abc123.";
    private final String USER_ADMIN="admin";
    private final String PASS_ADMIN="abc123.";
    public final static String NOME = "nome";
    private LoginViewModel loginViewModel;

    private void login(){
        Button btnLogin=findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etUser= findViewById(R.id.etUsuario);
                String user=etUser.getText().toString();
                EditText etPass=findViewById(R.id.etPassword);
                String pass=etPass.getText().toString();
                Usuario uIntroducido= new Usuario(user,pass);
                Log.i("usuario introducido",uIntroducido.getUsuario());

                switch (loginViewModel.login(uIntroducido)){
                    case LoginViewModel.LOGIN_OK:
                        Usuario usuario=loginViewModel.dameUsuario(uIntroducido);
                        String tipo = loginViewModel.dameTipo(usuario);
                        switch (tipo){
                            case "admin":
                                Intent intent = new Intent(getApplicationContext(), AdminActiviti.class);
                                intent.putExtra(NOME,user);
                                startActivity(intent);
                                finish();
                                break;
                            case "user":
                                Intent intentUser= new Intent(getApplicationContext(), UsuatioActivity.class);
                                intentUser.putExtra(NOME,user);
                                startActivity(intentUser);
                                finish();
                                break;
                        }
                        break;
                        case LoginViewModel.LOGIN_ERR_CONT:
                            Toast.makeText(getApplicationContext(),"Erro no contrasinal",Toast.LENGTH_LONG).show();
                            break;
                            case LoginViewModel.LOGIN_ERR_USUARIO:
                                Toast.makeText(getApplicationContext(),"Erro no usuario",Toast.LENGTH_LONG).show();
                                break;
                }



//                if (chkAdmin.isChecked()){
//                    if(user.equals(USER_ADMIN) && pass.equals(PASS_ADMIN)){
//                        Toast.makeText(getApplicationContext(),"Login con exito de administrador", Toast.LENGTH_LONG).show();
//                        Intent intent = new Intent(getApplicationContext(),AdminActiviti.class);
//                        startActivity(intent);
//                        finish();
//                    }else{
//                        Toast.makeText(getApplicationContext(),"Login como administrador erroneo", Toast.LENGTH_LONG).show();
//                    }
//
//                }else{
//                    if(user.equals(USER_USUARIO) && pass.equals(PASS_USUARIO)){
//                        Toast.makeText(getApplicationContext(),"Login con exito de usuario", Toast.LENGTH_LONG).show();
//                        Intent intent= new Intent(getApplicationContext(),UsuatioActivity.class);
//                        intent.putExtra(NOME,user);
//                        startActivity(intent);
//                        finish();
//                    }else{
//                        Toast.makeText(getApplicationContext(),"Login erroneo de usuario", Toast.LENGTH_LONG).show();
//                    }
//                }
            }
        });
    }
    public void rexistrarNovo(){
        Button btnRexistrar=(Button)findViewById(R.id.btnLgRexistrar);
                btnRexistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRexistro=new Intent(getApplicationContext(), RexistroUsusarioActivity.class);
                startActivity(intentRexistro);
                finish();
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.loginViewModel= new ViewModelProvider(this).get(LoginViewModel.class);
        login();
        rexistrarNovo();
    }
}
