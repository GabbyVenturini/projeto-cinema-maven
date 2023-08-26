package org.example.features.home.entity;

public class Usuario {
    private int id;
    private String nome;
    private String role;
    private int idade;
    private String user;
    private String password;

    public Usuario(int id, String nome, String role, int idade, String user, String password){
        this.id = id;
        this.nome = nome;
        this.role = role;
        this.idade = idade;
        this.user = user;
        this.password = password;
    }

    //Todo: Métodos Seters

    public void setId (int id){
        this.id = id;
    }
    public void setNome (String nome){
        this.nome = nome;
    }
    public void setRole (String role){
        this.role = role;
    }
    public void setIdade (int idade){
        this.idade = idade;
    }
    public void setUser (String user){
        this.user = user;
    }
    public void setPassword (String password){
        this.password = password;
    }

    //Todo: Métodos Geters

    public int getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public String getRole(){
        return role;
    }
    public int getIdade(){
        return idade;
    }
    public String getUser(){
        return user;
    }
    public String getPassword(){
        return password;
    }
}

