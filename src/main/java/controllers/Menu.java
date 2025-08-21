package controllers;

import models.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    protected Scanner scanner;
    protected BaseController baseController;
    protected List<Escola> escolas;
    protected static final String ARQUIVO_ESCOLAS = "escolas.dat";

    //todo Construtor do Menu
    public Menu() {
        this.scanner = new Scanner(System.in);
        this.baseController = new BaseController();
        this.escolas = carregarEscolas();
    }

    //todo Método público para iniciar o menu
    public void iniciarMenu() {
        exibirMenuPrincipal();
    }

    //todo Método que lê o arquivo escolas.dat e retorna ele como uma lista de escolas
    @SuppressWarnings("unchecked")
    protected List<Escola> carregarEscolas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO_ESCOLAS))) {
            return (List<Escola>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de escolas não encontrado. Criando nova lista.");
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar escolas. Criando nova lista.");
            return new ArrayList<>();
        }
    }

    //todo Método que salva as informações da lista de escolas no arquivo escolas.dat
    protected void salvarEscolas() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_ESCOLAS))) {
            oos.writeObject(escolas);
        } catch (IOException e) {
            System.out.println("Erro ao salvar escolas: " + e.getMessage());
        }
    }

    //todo Menu para escolher e criar escolas
    protected void exibirMenuPrincipal() {
        int opcao;
        do {
            System.out.println("\n|| Sistema de Escolas ||");
            System.out.println("1 - Escolher escola");
            System.out.println("2 - Listar escolas");
            System.out.println("3 - Criar nova escola");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> escolherEscola();
                case 2 -> listarEscolas();
                case 3 -> criarNovaEscola();
                case 4 -> {
                    salvarEscolas();
                    System.out.println("Saindo do sistema...");
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }

    //todo Método que redireciona para o menu da escola específica
    protected void escolherEscola() {
        System.out.print("Digite o nome da escola: ");
        String nomeEscola = scanner.nextLine();

        Escola escolaSelecionada = null;
        for (Escola escola : escolas) {
            if (escola.getNome().equalsIgnoreCase(nomeEscola)) {
                escolaSelecionada = escola;
                break;
            }
        }

        if (escolaSelecionada == null) {
            System.out.println("Escola não existente.");
            return;
        }

        exibirMenuEscola(escolaSelecionada);
    }

    //todo Método para listar escolas
    protected void listarEscolas() {
        if (escolas.isEmpty()) {
            System.out.println("Nenhuma escola cadastrada.");
            return;
        }

        System.out.println("\nLista de Escolas:");
        for (Escola escola : escolas) {
            System.out.println("- " + escola.getNome());
        }
    }

    //todo Método para criar novas escolas
    protected void criarNovaEscola() {
        System.out.print("Digite o nome da nova escola: ");
        String nomeEscola = scanner.nextLine();

        for (Escola escola : escolas) {
            if (escola.getNome().equalsIgnoreCase(nomeEscola)) {
                System.out.println("Erro: Escola já existente.");
                return;
            }
        }

        Escola novaEscola = new Escola(nomeEscola);
        escolas.add(novaEscola);
        System.out.println("Escola criada com sucesso.");
    }

    //todo Menu da escola específica/ escola escolhida
    protected void exibirMenuEscola(Escola escola) {
        int opcao;
        do {
            System.out.println("\n|| " + escola.getNome() + " ||");
            System.out.println("1 - Informações básicas");
            System.out.println("2 - Listar professores");
            System.out.println("3 - Listar alunos");
            System.out.println("4 - Listar disciplinas");
            System.out.println("5 - Adicionar disciplina");
            System.out.println("6 - Remover disciplina");
            System.out.println("7 - Adicionar professor");
            System.out.println("8 - Remover professor");
            System.out.println("9 - Adicionar aluno");
            System.out.println("10 - Remover aluno");
            System.out.println("11 - Adicionar disciplina para aluno");
            System.out.println("12 - Remover disciplina para aluno");
            System.out.println("13 - Mudar diretor da escola");
            System.out.println("14 - Voltar ao menu anterior");
            System.out.print("Escolha uma opção: ");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> baseController.exibirInformacoesBasicasMenu(escola);
                case 2 -> baseController.listarProfessoresMenu(escola);
                case 3 -> baseController.listarAlunosMenu(escola);
                case 4 -> baseController.listarDisciplinasMenu(escola);
                case 5 -> baseController.adicionarDisciplinaMenu(escola);
                case 6 -> baseController.removerDisciplinaMenu(escola);
                case 7 -> baseController.adicionarProfessorMenu(escola);
                case 8 -> baseController.removerProfessorMenu(escola);
                case 9 -> baseController.adicionarAlunoMenu(escola);
                case 10 -> baseController.removerAlunoMenu(escola);
                case 11 -> baseController.adicionarDisciplinaAlunoMenu(escola);
                case 12 -> baseController.removerDisciplinaAlunoMenu(escola);
                case 13 -> baseController.mudarDiretorMenu(escola);
                case 14 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 14);
    }
}