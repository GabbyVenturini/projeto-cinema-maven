package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            SalaCinema salaCinema = new SalaCinema();
            Scanner scanner = new Scanner(System.in);

            int opcao;
            do {
                System.out.println("==============MENU INICIAL==============");
                System.out.println("[1] Entrar                             |");
                System.out.println("[2] Cadastrar                          |");
                System.out.println("[3] Sair                               |");
                System.out.println("========================================");
                System.out.print("Escolha uma opção:                        ");

                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.print("User: ");
                        String userLogin = scanner.next();
                        System.out.print("Password: ");
                        String passwordLogin = scanner.next();
                        salaCinema.login(userLogin, passwordLogin);
                        break;
                    case 2:
                        System.out.print("Nome: ");
                        String nomeCadastro = scanner.next();
                        System.out.print("Role (cliente/funcionario): ");
                        String roleCadastro = scanner.next();
                        System.out.print("Idade: ");
                        int idadeCadastro = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("User: ");
                        String userCadastro = scanner.next();
                        System.out.print("Password: ");
                        String passwordCadastro = scanner.next();
                        salaCinema.cadastrarUsuario(nomeCadastro, roleCadastro, idadeCadastro, userCadastro, passwordCadastro);
                        break;
                    case 3:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } while (opcao != 3);
        }
    }