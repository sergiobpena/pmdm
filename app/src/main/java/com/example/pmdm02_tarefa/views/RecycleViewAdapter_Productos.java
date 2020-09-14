package com.example.pmdm02_tarefa.views;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm02_tarefa.R;
import com.example.pmdm02_tarefa.repositorios.entidades.Departamento;
import com.example.pmdm02_tarefa.repositorios.entidades.Producto;

import java.util.List;

public class RecycleViewAdapter_Productos extends RecyclerView.Adapter {

    private List<Producto> productos;
    private List<Departamento> departamentos;
    private final LayoutInflater inflater;

    class Productos_Adapter extends RecyclerView.ViewHolder{
        public TextView titulo;
        public TextView prezo;
        public ImageView imaxe;
        public Productos_Adapter(@NonNull View itemView) {
            super(itemView);
            titulo=itemView.findViewById(R.id.prod_txtv_card_titulo);
            prezo=itemView.findViewById(R.id.prod_txtv_card_prezo);
            imaxe=itemView.findViewById(R.id.prod_card_imaxe);
        }
    }
    public RecycleViewAdapter_Productos(Context context){
        inflater=LayoutInflater.from(context);
    }
    //Convertir o layout a view
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater minflater= (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = minflater.inflate(R.layout.card_producto_layout,parent,false);
        RecyclerView.ViewHolder viewHolder= new Productos_Adapter(v);
        return viewHolder;
    }
    //Insertar datos
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Productos_Adapter productos_adapter= (Productos_Adapter) holder;
        //engadir datos como corresponda
        if(productos != null){
            Producto p=productos.get(position);
            ((Productos_Adapter) holder).titulo.setText(p.getNome_producto());
            ((Productos_Adapter) holder).prezo.setText(""+p.getPrezo());
        }else{
            Log.e("Non hai productos","Noooo");
        }
    }
    public void setProductos(List<Producto> productos){
        this.productos=productos;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if(productos !=null){
            return productos.size();
        }else{
            return 0;
        }
    }
}
