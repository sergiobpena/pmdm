package com.example.pmdm02_tarefa.dao.contract;

import android.provider.BaseColumns;

import com.example.pmdm02_tarefa.dao.dto.Usuario;

public final class TendaContract {
    private TendaContract(){}
    public static final DepartamentoTaboa departamentoTaboa= new DepartamentoTaboa();
    public static final ProductoTaboa productoTaboa=new ProductoTaboa();
    public static final PedidoEstadosTaboa pedidoEstadosTaboa=new PedidoEstadosTaboa();
    public static final UsuarioTipoTaboa usuarioTipoTaboa= new UsuarioTipoTaboa();
    public static final UsuarioTaboa usuarioTaboa= new UsuarioTaboa();
    public static final DireccionTaboa direccionTaboa=new DireccionTaboa();
    public static final PedidoProductoTaboa pedidoProductoTaboa=new PedidoProductoTaboa();
}
