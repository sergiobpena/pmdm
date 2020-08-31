package com.example.pmdm02_tarefa.dao.dto;

public class Usuario {

    private String usuario;
    private String nome;
    private String apeliso_1;
    private String apelido_2;
    private int telefono;
    private String correoe;
    private String contrasinal;

    public Usuario(String nome , String contrasinal){
        this.nome=nome;
        this.contrasinal=contrasinal;

    }
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApeliso_1() {
        return apeliso_1;
    }

    public void setApeliso_1(String apeliso_1) {
        this.apeliso_1 = apeliso_1;
    }

    public String getApelido_2() {
        return apelido_2;
    }

    public void setApelido_2(String apelido_2) {
        this.apelido_2 = apelido_2;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreoe() {
        return correoe;
    }

    public void setCorreoe(String correoe) {
        this.correoe = correoe;
    }

    public String getContrasinal() {
        return contrasinal;
    }

    public void setContrasinal(String contrasinal) {
        this.contrasinal = contrasinal;
    }
    public String toString(){
        return this.nome+" "+this.apeliso_1+" "+this.apelido_2;
    }
}
