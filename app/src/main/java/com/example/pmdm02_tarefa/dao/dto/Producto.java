package com.example.pmdm02_tarefa.dao.dto;

public class Producto {
    private String nome;
    private String departamento;
    private double prezo;
    public Producto (String nome, String departamento, Double prezo){
        this.nome=nome;
        this.prezo=prezo;
        this.departamento=departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getPrezo() {
        return prezo;
    }

    public void setPrezo(double prezo) {
        this.prezo = prezo;
    }

    public String toString(){
        return this.nome;
    }
}
