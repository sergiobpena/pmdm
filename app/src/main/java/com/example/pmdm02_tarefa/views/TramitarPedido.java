package com.example.pmdm02_tarefa.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.pmdm02_tarefa.R;
import com.example.pmdm02_tarefa.repositorios.entidades.Producto;
import com.example.pmdm02_tarefa.viewModels.ProductosViewModel;

import java.util.List;

public class TramitarPedido extends AppCompatActivity {

    EditText cantidadeEt;
    public final static String categoriaPedida="CATEGORIA";
    public final static String productoPedido="PRODUCTO";
    public final static String cantidadePedida="CANTIDADE";
    private final int COD_PETICION=34;
    private ProductosViewModel productosViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tramitar_pedido);
        RecyclerView recyclerView= findViewById(R.id.prod_recycler);
        final RecycleViewAdapter_Productos recycleViewAdapter_productos= new RecycleViewAdapter_Productos(this);
        recyclerView.setAdapter(recycleViewAdapter_productos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productosViewModel=new ViewModelProvider(this).get(ProductosViewModel.class);
        productosViewModel.getProductos().observe(this, new Observer<List<Producto>>() {
            @Override
            public void onChanged(List<Producto> productos) {
                recycleViewAdapter_productos.setProductos(productos);
            }
        });
//        xestionCategorias();
        xestionBotons();
    }
    private void xestionBotons(){
        Button btnSair= findViewById(R.id.btnSair);
        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
        Button btnFacerPedido=findViewById(R.id.btnAceptar);
        btnFacerPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent= new Intent(getApplicationContext(),DatosDeEnvio.class);
//                intent.putExtra(categoriaPedida,spCategoria.getSelectedItem().toString());
//                intent.putExtra(productoPedido,spProducto.getSelectedItem().toString());
//                intent.putExtra(categoriaPedida,cantidadeEt.getText().toString());
//                startActivityForResult(intent,34);
//                finish();
            }
        });
    }
//    private void xestionProducto(){
//        this.spProducto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//    }
//    private void xestionCategorias() {
//        this.spCategoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String seleccion=parent.getItemAtPosition(position).toString();
//                switch (seleccion){
//                    case "Informatica":
//                        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(view.getContext(),
//                                R.array.productos_informatica, android.R.layout.simple_spinner_item);
//                        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                        spProducto.setAdapter(adapter1);
//                        break;
//                    case "Electronica":
//                        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(view.getContext(),
//                                R.array.productos_electronica, android.R.layout.simple_spinner_item);
//                        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                        spProducto.setAdapter(adapter2);
//                        break;
//                    case "Mobiles":
//                        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(),
//                                R.array.productos_mobiles, android.R.layout.simple_spinner_item);
//                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                        spProducto.setAdapter(adapter);
//                        break;
//                        default:
//                            break;
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//    }
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data){
//        if(requestCode == 34){
//            if (resultCode  == RESULT_OK){
////                Intent intent= new Intent(getApplicationContext(),UsuatioActivity.class);
//                setResult(RESULT_OK);
//                finish();
//            }
//        }else {
//            //todo mal
//        }
//    }
}
