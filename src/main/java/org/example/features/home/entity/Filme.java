package org.example.features.home.entity;

import org.example.features.home.interfaces.SubtrairPoltrona;

public class Filme implements SubtrairPoltrona {
    private int id;
    private String titulo;
    private String genero;
    private int idadeMinima;
    private int tempo;
    private double valor;
    private String tecnologia;
    private int poltronasDisponiveis;

    //Todo: Construtor

    public Filme(int novoId, String titulo, String genero, int idadeMinima, int tempo, double valor, String tecnologia, int poltronasDisponiveis) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.idadeMinima = idadeMinima;
        this.valor = valor;
        this.tecnologia = tecnologia;
        this.poltronasDisponiveis = poltronasDisponiveis;
    }
    //Todo: Métodos Seters

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setIdadeMinima(int idadeMinima) {
        this.idadeMinima = idadeMinima;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public void setPoltronasDisponiveis(int poltronasDisponiveis) {
        this.poltronasDisponiveis = poltronasDisponiveis;
    }

    //Todo: Métodos Geters


    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public int getIdadeMinima() {
        return idadeMinima;
    }

    public int getTempo() {
        return tempo;
    }

    public double getValor() {
        return valor;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public int getPoltronasDisponiveis() {
        return poltronasDisponiveis;
    }

    //Todo: Método Subtrair Poltronas
    @Override
    public void subtrairPoltronaDisponivel() {
        if (poltronasDisponiveis > 0) {
            poltronasDisponiveis--;
        }
    }
}


