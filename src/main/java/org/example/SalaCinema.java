package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class SalaCinema {
    private List<Filme> filmes;
    private List<Usuario> usuarios;
    private List<Ingresso> ingressos;
    private boolean[] poltronasOcupadas;

    private Usuario usuarioLogado;

    public SalaCinema() {
        poltronasOcupadas = new boolean[100];
        filmes = new ArrayList<>();
        usuarios = new ArrayList<>();
        ingressos = new ArrayList<>();
        usuarioLogado = null;
    }

    public boolean excluirFilmeDoCartaz(Scanner scanner) {
        System.out.println("-------------------------------------");
        System.out.print("Digite o nome do filme a ser excluído: ");
        int idFilme = scanner.nextInt();

        for (Filme filme : filmes) {
            if (filme.getId() == idFilme) {
                if (podeExcluirFilme(idFilme)) {
                    filmes.remove(filme);
                    return true;
                } else {
                    System.out.println("Não é possível excluir o filme. Ingressos já vendidos.");
                    return false;
                }
            }
            System.out.println("=--------------------------------------------------------------");
        }

        System.out.println("Filme não encontrado.");
        return false;
    }

    private boolean podeExcluirFilme(int idFilme) {
        for (Ingresso ingresso : ingressos) {
            if (ingresso.getIdFilme() == idFilme) {
                return false;
            }
        }
        return true;
    }
    public void listarFilmesEmCartaz() {
            System.out.println("----------------> Filmes em Cartaz <-----------------");
        for (Filme filme : filmes) {
            System.out.println("Id: " + filme.getId());
            System.out.println("Título: " + filme.getTitulo());
            System.out.println("Gênero: " + filme.getGenero());
            System.out.println("Idade Mínima: " + filme.getIdadeMinima());
            System.out.println("Duração: " + filme.getTempo() + "minutos");
            System.out.println("Valor do Ingresso: R$                 " + filme.getValor());
            System.out.println("Poltronas Disponíveis: " + filme.getPoltronasDisponiveis());
            System.out.println("-----------------------------------------------------");
        }
    }
    //Todo: Método Comprar ingresso
    public boolean comprarIngresso(String login, int idFilme, int numeroPoltrona) {
        Filme filme = buscarFilmePorId(idFilme);
        Usuario usuario = buscarUsuarioPorUser(login);

        if (filme != null && usuario != null) {
            if (verificarIdadeUsuario(login, idFilme)) {
                if (numeroPoltrona >= 1 && numeroPoltrona <= 100 && !poltronasOcupadas[numeroPoltrona - 1]) {
                    poltronasOcupadas[numeroPoltrona - 1] = true;
                    filme.subtrairPoltronaDisponivel();
                    ingressos.add(new Ingresso(idFilme, usuario.getId(), numeroPoltrona));
                    return true;
                } else {
                    System.out.println("Poltrona inválida ou já ocupada.");
                }
            } else {
                System.out.println("Você não tem idade suficiente para assistir a este filme.");
            }
        } else {
            System.out.println("Filme ou usuário não encontrado.");
        }

        return false;
    }
    //Todo: Método Verificar Idade do Usuário
    private boolean verificarIdadeUsuario(String login, int idFilme) {
        Usuario usuario = buscarUsuarioPorUser(login);
        Filme filme = buscarFilmePorId(idFilme);

        if (usuario != null && filme != null) {
            return usuario.getIdade() >= filme.getIdadeMinima();
        } else {
            return false;
        }
    }

    //Todo: Método Buscar Usuário por User
    private Usuario buscarUsuarioPorUser(String login) {
        for (Usuario usuario : usuarios) {
            if (Objects.equals(usuario.getUser(), login)) {
                return usuario;
            }
        }
        return null;
    }

    //Todo: Método Buscar Usuário por Id
    private Filme buscarFilmePorId(int idFilme) {
        for (Filme filme : filmes) {
            if (filme.getId() == idFilme) {
                return filme;
            }
        }
        return null;
    }

    //Todo: Método de Login
    public void login(String login, String password) {
        Usuario usuarioEncontrado = buscarUsuarioPorUser(login);

        if (usuarioEncontrado != null && usuarioEncontrado.getPassword().equals(password)) {
            usuarioLogado = usuarioEncontrado;
            System.out.println("Login realizado com sucesso.");
            if (usuarioLogado.getRole().equals("funcionario")) {
                exibirMenuFuncionario();
            } else if (usuarioLogado.getRole().equals("cliente")) {
                exibirMenuCliente();
            } else {
                System.out.println("Papel de usuário desconhecido.");
            }
        } else {
            System.out.println("Usuário ou senha incorretos.");
        }
    }

    //Todo: Método de Cadastrar Usuário
    public void cadastrarUsuario(String nome, String role, int idade, String user, String password) {
        int novoId = usuarios.size() + 1;
        usuarios.add(new Usuario(novoId, nome, role, idade, user, password));
        System.out.println("Usuário cadastrado com sucesso.");
    }

    //Todo: Método para dizer que usuário logado é funcionário
    private boolean usuarioLogadoIsFuncionario() {
        return usuarioLogado != null && "funcionario".equals(usuarioLogado.getRole());
    }

    public void cadastrarFilme(Scanner scanner) {
        System.out.println("-----------------------------------------------------");
        System.out.println("Bem vindo ao cadastro de filmes:");
        System.out.println("-----------------------------------------------------");

        System.out.print("Digite o título do filme: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite o gênero do filme: ");
        String genero = scanner.next();

        System.out.print("Digite a idade mínima para o filme: ");
        int idadeMinima = scanner.nextInt();

        System.out.print("Digite a duração do filme em minutos: ");
        int tempo = scanner.nextInt();

        System.out.print("Digite o valor do ingresso: ");
        double valor = scanner.nextDouble();

        System.out.print("Digite a tecnologia do filme: ");
        String tecnologia = scanner.next();

        System.out.print("Digite o número de poltronas disponíveis: ");
        int poltronasDisponiveis = scanner.nextInt();

        int novoId = filmes.size() + 1;
        Filme novoFilme = new Filme(novoId, titulo, genero, idadeMinima, tempo, valor, tecnologia, poltronasDisponiveis);

        filmes.add(novoFilme);

        System.out.println("Filme cadastrado com sucesso.");

        System.out.println("-----------------------------------------------------");
    }

    //Todo: Método de Comprar Ingresso
    private void comprarIngressoMenu(Scanner scanner) {
        listarFilmesEmCartaz();
        System.out.print("Digite o ID do filme que deseja comprar ingresso: ");
        int idFilme = scanner.nextInt();

        Filme filme = buscarFilmePorId(idFilme);
        if (filme == null) {
            System.out.println("Filme não encontrado.");
            return;
        }

        System.out.print("Digite o número da poltrona desejada: ");
        int numeroPoltrona = scanner.nextInt();

        if (comprarIngresso(usuarioLogado.getUser(), idFilme, numeroPoltrona)) {
            System.out.println("Ingresso comprado com sucesso!");
        } else {
            System.out.println("Não foi possível comprar o ingresso.");
        }
        System.out.println("-----------------------------------------------------");
    }

    //Todo: Método de Visualizar Ingresso do Cliente
    private void visualizarIngressosDoUsuario() {
        System.out.println("Ingressos comprados pelo usuário:");
        for (Ingresso ingresso : ingressos) {
            if (ingresso.getIdUsuario() == usuarioLogado.getId()) {
                Filme filme = buscarFilmePorId(ingresso.getIdFilme());
                System.out.println("Filme: " + filme.getTitulo());
                System.out.println("Poltrona: " + ingresso.getNumeroPoltrona());
            }
        }
    }
    //Todo: Método de Exibir Menu do Funcionário
    private void exibirMenuFuncionario() {
        if (!usuarioLogadoIsFuncionario()) {
            System.out.println("Acesso restrito aos funcionários.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("------------------> Menu Funcionário <-------------------");
            System.out.println("[1] Cadastrar novo filme                                |");
            System.out.println("[2] Excluir filme do cartaz                             |");
            System.out.println("[3] Listar filmes em cartaz                             |");
            System.out.println("[4] Efetuar logout                                      |");
            System.out.println("---------------------------------------------------------");
            System.out.print("Escolha uma opção:                                         ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarFilme(scanner);
                    break;
                case 2:
                    excluirFilmeDoCartaz(scanner);
                    break;
                case 3:
                    listarFilmesEmCartaz();
                    break;
                case 4:
                    System.out.println("Logout realizado com sucesso.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

            System.out.println("-----------------------------------------------------");
        } while (opcao != 4);
    }
    //Todo: Método de Exibir Menu do Cliente
    private void exibirMenuCliente() {
        if (usuarioLogado == null || !"cliente".equals(usuarioLogado.getRole())) {
            System.out.println("Acesso restrito aos clientes.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("------------------> Menu Cliente <-------------------");
            System.out.println("[1] Listar filmes em cartaz                         |");
            System.out.println("[2] Comprar ingresso                                |");
            System.out.println("[3] Visualizar meus ingressos                       |");
            System.out.println("[4] Efetuar logout                                  |");
            System.out.println("-----------------------------------------------------");
            System.out.print("Escolha uma opção:                                     ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    listarFilmesEmCartaz();
                    break;
                case 2:
                    comprarIngressoMenu(scanner);
                    break;
                case 3:
                    visualizarIngressosDoUsuario();
                    break;
                case 4:
                    usuarioLogado = null;
                    System.out.println("Logout realizado com sucesso.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

            System.out.println("------------------------------------------------------");
        } while (opcao != 4);
    }
}
