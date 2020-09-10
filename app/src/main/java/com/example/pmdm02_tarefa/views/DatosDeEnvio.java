package com.example.pmdm02_tarefa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DatosDeEnvio extends AppCompatActivity {
    String [] datos=new String[3];
    EditText direccion;
    EditText cidade;
    EditText cp;
    private final int COD_PETICION=33;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_de_envio);
        Intent intent=getIntent();
        this.datos[0]=intent.getExtras().getString(TramitarPedido.cantidadePedida);
        this.datos[1]=intent.getExtras().getString(TramitarPedido.categoriaPedida);
        this.datos[2]=intent.getExtras().getString(TramitarPedido.productoPedido);

        this.direccion=findViewById(R.id.txtDireccion);
        this.cidade=findViewById(R.id.txtCidade);
        this.cp=findViewById(R.id.txtCodPost);
        xestionarBotons();
    }

    private void xestionarBotons(){
        Button btnsair=findViewById(R.id.btnSair);
        Button btnaceptar=findViewById(R.id.btnAceptar);

        btnsair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),TramitarPedido.class);
                setResult(RESULT_CANCELED);
                startActivityForResult(intent,33);
                finish();
            }
        });

        btnaceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cidadeString=cidade.getText().toString();
                String direccionString=direccion.getText().toString();
                String cpString=cp.getText().toString();
                String textoToast="Categoria : " + datos[1] +"\tProducto : " +  datos[2] +"\t Cantidade " +  datos[0] +"\tDireccion : " +  direccionString +"\t Cidade" +  cidadeString + "\tCodigo postal" + cpString ;
                Toast.makeText(getApplicationContext(),textoToast, Toast.LENGTH_LONG).show();
                Intent intent= new Intent(getApplicationContext(),TramitarPedido.class);
                setResult(RESULT_OK);
                startActivityForResult(intent,33);
//                startActivity(intent);
                finish();
            }
        });
    }
}
