package com.example.fatcars.model;

import java.text.NumberFormat;

public class Carro {
    private String marca;
    private String Modelo;
    private String ano;
    private int modeloCar;
    //onclick
    private int Kilometragem;
    private boolean Disponivel;
    private String Proprietario;
    //private Float Preço ;
    private String preço; /*NumberFormat.getCurrencyInstance().format(0.01);*/
    private String Local;



    //onclick
   public Carro(String marca, String modelo, String ano, int modeloCar,
                 boolean Disponivel, String preço, String Local) {
        this.marca = marca;
        Modelo = modelo;
        this.ano = ano;
        this.modeloCar = modeloCar;
        //this.Kilometragem = Kilometragem;
        this.Disponivel = Disponivel;
       // this.Proprietario = Proprietario;
        this.preço = preço;
        this.Local = Local;
    }



    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public int getModeloCar() {
        return modeloCar;
    }

    public void setModeloCar(int modeloCar) {
        this.modeloCar = modeloCar;
    }

    public int getKilometragem() {
        return Kilometragem;
    }

    public void setKilometragem(int kilometragem) {
        Kilometragem = kilometragem;
    }

    public boolean isDisponivel() {
        return Disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        Disponivel = disponivel;
    }

    public String getProprietario() {
        return Proprietario;
    }

    public void setProprietario(String proprietario) {
        Proprietario = proprietario;
    }

    public String getPreço() {
        return preço;
    }

    public void setPreço(String preço) {
        this.preço = preço;
    }

    public String getLocal() {
        return Local;
    }

    public void setLocal(String local) {
        Local = local;
    }
}
