package com.example.pmdm02_tarefa;

import androidx.annotation.IntRange;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String USER_USUARIO="usuario";
    private final String PASS_USUARIO="abc123.";
    private final String USER_ADMIN="admin";
    private final String PASS_ADMIN="abc123.";
    public final static String NOME = "nome";

    private void login(){
        Button btnLogin=findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etUser= findViewById(R.id.etUsuario);
                String user=etUser.getText().toString();
                Log.i("Usuario",user);
                EditText etPass=findViewById(R.id.etPassword);
                String pass=etPass.getText().toString();
                Log.i("Contrasinal",pass);
                CheckBox chkAdmin=findViewById(R.id.chkAdmin);
                if (chkAdmin.isChecked()){
                    if(user.equals(USER_ADMIN) && pass.equals(PASS_ADMIN)){
                        Toast.makeText(getApplicationContext(),"Login con exito de administrador", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(),AdminActiviti.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(),"Login como administrador erroneo", Toast.LENGTH_LONG).show();
                    }

                }else{
                    if(user.equals(USER_USUARIO) && pass.equals(PASS_USUARIO)){
                        Toast.makeText(getApplicationContext(),"Login con exito de usuario", Toast.LENGTH_LONG).show();
                        Intent intent= new Intent(getApplicationContext(),UsuatioActivity.class);
                        intent.putExtra(NOME,user);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(),"Login erroneo de usuario", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login();
    }
}
