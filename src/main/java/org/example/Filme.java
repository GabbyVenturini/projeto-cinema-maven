package org.example;

public class Filme {
    private int id;
    private String titulo;
    private String genero;
    private int idadeMinima;
    private int tempo;
    private double valor;
    private String tecnologia;
    private String poltronasDisponiveis;

    //Todo: Construtor

    public Filme(int novoId, String titulo, String genero, int idadeMinima, int tempo, double valor, String tecnologia, int poltronasDisponiveis) {
        this.id = id;
        this.titulo = this.titulo;
        this.genero = this.genero;
        this.idadeMinima = this.idadeMinima;
        this.valor = this.valor;
        this.tecnologia = this.tecnologia;
        this.poltronasDisponiveis = this.poltronasDisponiveis;
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

    public void setPoltronasDisponiveis(String poltronasDisponiveis) {
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

    //Todo: Método Poltronas Disponíveis
    public String getPoltronasDisponiveis() {
        return poltronasDisponiveis;
    }
    //Todo: Método Subtrair Poltronas
    public void subtrairPoltronaDisponivel() {
        if (poltronasDisponiveis > 0) {
            poltronasDisponiveis--;
        }
    }
}


