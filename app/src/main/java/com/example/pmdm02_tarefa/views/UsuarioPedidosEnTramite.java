package com.example.pmdm02_tarefa.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pmdm02_tarefa.R;

public class UsuarioPedidosEnTramite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_pedidos_en_tramite);
        Button btnSair= findViewById(R.id.btnSairUsuarioPedidosTramite);
        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
