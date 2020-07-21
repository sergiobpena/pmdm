package com.example.pmdm02_tarefa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UsuatioActivity extends AppCompatActivity {
    TextView txtUsuario;
    private final int COD_PETICION=33;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuatio);

        Intent intent=getIntent();
        String texto= intent.getExtras().getString(MainActivity.NOME);
        txtUsuario=findViewById(R.id.textViewNomeUsuario);

        txtUsuario.append("\n" + texto);
        xestionarBotonSair();
    }

    @Override
    protected void onSaveInstanceState(Bundle datosgardados){
        datosgardados.putString("NOME",txtUsuario.getText().toString());
        super.onSaveInstanceState(datosgardados);
    }
    @Override
    protected void onRestoreInstanceState(Bundle datosgardados){
        super.onRestoreInstanceState(datosgardados);
        txtUsuario.setText(datosgardados.getString("NOME"));
    }

    private void xestionarBotonSair() {
        Button botonsair= findViewById(R.id.btnPecharUsuario);
        botonsair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Button tramitarPedido=findViewById(R.id.btnFacerPedido);
        tramitarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),TramitarPedido.class);
                startActivityForResult(intent,COD_PETICION);
//                intent.putExtra(NOME,user);
                startActivity(intent);
//                finish();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == COD_PETICION){
            if (requestCode == RESULT_OK){
                //TODO BIEN
            }
        }else {
            //todo mal
        }
    }

}
