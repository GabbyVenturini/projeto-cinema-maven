package org.example.features.home.interfaces;

import org.example.features.home.entity.Usuario;
import org.example.features.home.entity.Filme;

import java.util.Scanner;

public interface Bilheteria {
    boolean excluirFilmeDoCartaz(Scanner scanner);

    boolean podeExcluirFilme(int idFilme);

    void listarFilmesEmCartaz();

    boolean comprarIngresso(String login, int idFilme, int numeroPoltrona);

    boolean verificarIdadeUsuario(String login, int idFilme);

    Usuario buscarUsuarioPorUser(String login);

    Filme buscarFilmePorId(int idFilme);

    void login(String login, String password);

    void cadastrarUsuario(String nome, String role, int idade, String user, String password);

    boolean usuarioLogadoIsFuncionario();

    void cadastrarFilme(Scanner scanner);


    void comprarIngressoMenu(Scanner scanner);

    void visualizarIngressosDoUsuario();

    void exibirMenuFuncionario();

    void exibirMenuCliente();

}