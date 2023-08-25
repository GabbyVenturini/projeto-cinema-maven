package org.example;

public class Ingresso {
    private int idFilme;
    private int idUsuario;
    private int numeroPoltrona;

    //Todo: Construtor

    public Ingresso(int idFilme, int idUsuario, int numeroPoltrona){
        this.idFilme = idFilme;
        this.idUsuario  =idUsuario;
        this.numeroPoltrona = numeroPoltrona;
    }
    //Todo: Métodos Seters

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNumeroPoltrona(int numeroPoltrona) {
        this.numeroPoltrona = numeroPoltrona;
    }
    //Todo: Métodos Geters

    public int getIdFilme(){
        return idFilme;
    }
    public int getIdUsuario(){
        return idUsuario;
    }
    public int getNumeroPoltrona(){
        return numeroPoltrona;
    }

}
