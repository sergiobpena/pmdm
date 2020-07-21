package com.example.pmdm02_tarefa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class TramitarPedido extends AppCompatActivity {
    Spinner spCategoria;
    Spinner spProducto;
    EditText cantidadeEt;
    public final static String categoriaPedida="CATEGORIA";
    public final static String productoPedido="PRODUCTO";
    public final static String cantidadePedida="CANTIDADE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tramitar_pedido);
        this.spCategoria=findViewById(R.id.spCategoria);
        this.spProducto= findViewById(R.id.spProducto);
        this.cantidadeEt=findViewById(R.id.txtCantidade);
//        Resources res = getResources();
//        String [] categorias=res.getStringArray(R.array.catedorias);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.catedorias, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCategoria.setAdapter(adapter);
        xestionCategorias();
        xestionBotons();
    }
    private void xestionBotons(){
        Button btnSair= findViewById(R.id.btnSair);
        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button btnFacerPedido=findViewById(R.id.btnAceptar);
        btnFacerPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),DatosDeEnvio.class);
                intent.putExtra(categoriaPedida,spCategoria.getSelectedItem().toString());
                intent.putExtra(productoPedido,spProducto.getSelectedItem().toString());
                intent.putExtra(categoriaPedida,cantidadeEt.getText().toString());
                startActivity(intent);
                finish();
            }
        });
    }
    private void xestionProducto(){
        this.spProducto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void xestionCategorias() {
        this.spCategoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String seleccion=parent.getItemAtPosition(position).toString();
                switch (seleccion){
                    case "Informatica":
                        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(view.getContext(),
                                R.array.productos_informatica, android.R.layout.simple_spinner_item);
                        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spProducto.setAdapter(adapter1);
                        break;
                    case "Electronica":
                        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(view.getContext(),
                                R.array.productos_electronica, android.R.layout.simple_spinner_item);
                        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spProducto.setAdapter(adapter2);
                        break;
                    case "Mobiles":
                        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(),
                                R.array.productos_mobiles, android.R.layout.simple_spinner_item);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spProducto.setAdapter(adapter);
                        break;
                        default:
                            break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
