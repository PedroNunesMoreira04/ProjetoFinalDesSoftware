package controllers;

import models.*;
import java.util.Scanner;

public class BaseController {
    private Scanner scanner;

    public BaseController() {
        this.scanner = new Scanner(System.in);
    }

    //todo Método para exibir dados da escola
    protected void exibirInformacoesBasicasMenu(Escola escola) {
        escola.exibirInformacoesBasicas();
    }

    //todo Método para listar professores
    protected void listarProfessoresMenu(Escola escola) {
        escola.listarProfessores();
    }

    //todo Método para listar alunos
    protected void listarAlunosMenu(Escola escola) {
        escola.listarAlunos();
    }

    //todo Método para listar disciplina
    protected void listarDisciplinasMenu(Escola escola) {
        escola.listarDisciplinas();
    }

    //todo Método para adicionar disciplina
    protected void adicionarDisciplinaMenu(Escola escola) {
        System.out.print("Digite o nome da disciplina: ");
        String disciplina = scanner.nextLine();

        if (escola.contemDisciplina(disciplina)) {
            System.out.println("Erro: Disciplina já existente.");
        } else {
            escola.adicionarDisciplina(disciplina);
            System.out.println("Disciplina adicionada com sucesso.");
        }
    }

    //todo Método para remover disciplinas
    protected void removerDisciplinaMenu(Escola escola) {
        System.out.print("Digite o nome da disciplina: ");
        String disciplina = scanner.nextLine();

        if (!escola.contemDisciplina(disciplina)) {
            System.out.println("Erro: Disciplina não existente.");
            return;
        }

        //todo Método que verifica se algum professor leciona essa disciplina
        for (Professor professor : escola.getProfessores()) {
            if (professor.getDisciplina().equalsIgnoreCase(disciplina)) {
                System.out.println("Erro: Algum professor leciona essa disciplina.");
                return;
            }
        }

        //todo Método que remove a disciplina dos alunos que a possuem
        for (Aluno aluno : escola.getAlunos()) {
            if (aluno.getDisciplinas().contains(disciplina)) {
                aluno.removerDisciplina(disciplina);
            }
        }

        //todo Método que remove a disciplina da escola
        escola.removerDisciplina(disciplina);
        System.out.println("Disciplina removida com sucesso.");
    }

    //todo Método para adicionar professor
    protected void adicionarProfessorMenu(Escola escola) {
        System.out.print("Digite o nome do professor: ");
        String nome = scanner.nextLine();

        if (escola.contemProfessor(nome)) {
            System.out.println("Erro: Professor já existente.");
            return;
        }

        System.out.print("Digite a idade do professor: ");
        int idade = Integer.parseInt(scanner.nextLine());

        System.out.print("Digite o telefone do professor: ");
        String telefone = scanner.nextLine();

        System.out.print("Digite o salário do professor: ");
        double salario = Double.parseDouble(scanner.nextLine());

        System.out.print("Digite o email do professor: ");
        String email = scanner.nextLine();

        System.out.print("Digite a disciplina do professor: ");
        String disciplina = scanner.nextLine();

        if (!escola.contemDisciplina(disciplina)) {
            System.out.println("Erro: Disciplina não existente.");
            return;
        }

        Professor professor = new Professor(nome, idade, telefone, salario, email, disciplina);
        escola.adicionarProfessor(professor);
        System.out.println("Professor adicionado com sucesso.");
    }

    //todo Método para remover professor
    protected void removerProfessorMenu(Escola escola) {
        System.out.print("Digite o nome do professor: ");
        String nome = scanner.nextLine();

        Professor professor = escola.getProfessorPorNome(nome);
        if (professor == null) {
            System.out.println("Erro: Professor não existente.");
            return;
        }

        escola.removerProfessor(professor);
        System.out.println("Professor removido com sucesso.");
    }

    //todo Método para adicionar aluno
    protected void adicionarAlunoMenu(Escola escola) {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        if (escola.contemAluno(nome)) {
            System.out.println("Erro: Aluno já existente.");
            return;
        }

        System.out.print("Digite a idade do aluno: ");
        int idade = Integer.parseInt(scanner.nextLine());

        System.out.print("Digite o telefone do aluno: ");
        String telefone = scanner.nextLine();

        Aluno aluno = new Aluno(nome, idade, telefone);
        escola.adicionarAluno(aluno);
        System.out.println("Aluno adicionado com sucesso.");
    }

    //todo Método para remover aluno
    protected void removerAlunoMenu(Escola escola) {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        Aluno aluno = escola.getAlunoPorNome(nome);
        if (aluno == null) {
            System.out.println("Erro: Aluno não existente.");
            return;
        }

        escola.removerAluno(aluno);
        System.out.println("Aluno removido com sucesso.");
    }

    //todo Método para adicionar disciplina para o aluno
    protected void adicionarDisciplinaAlunoMenu(Escola escola) {
        System.out.print("Digite o nome do aluno: ");
        String nomeAluno = scanner.nextLine();

        Aluno aluno = escola.getAlunoPorNome(nomeAluno);
        if (aluno == null) {
            System.out.println("Erro: Aluno não existente.");
            return;
        }

        System.out.print("Digite o nome da disciplina: ");
        String disciplina = scanner.nextLine();

        if (!escola.contemDisciplina(disciplina)) {
            System.out.println("Erro: Disciplina não existente.");
            return;
        }

        aluno.adicionarDisciplina(disciplina);
        System.out.println("Disciplina adicionada ao aluno com sucesso.");
    }

    //todo Método para remover disciplina para o aluno
    protected void removerDisciplinaAlunoMenu(Escola escola) {
        System.out.print("Digite o nome do aluno: ");
        String nomeAluno = scanner.nextLine();

        Aluno aluno = escola.getAlunoPorNome(nomeAluno);
        if (aluno == null) {
            System.out.println("Erro: Aluno não existente.");
            return;
        }

        System.out.print("Digite o nome da disciplina: ");
        String disciplina = scanner.nextLine();

        if (!aluno.getDisciplinas().contains(disciplina)) {
            System.out.println("Erro: Disciplina não existente para este aluno.");
            return;
        }

        aluno.removerDisciplina(disciplina);
        System.out.println("Disciplina removida do aluno com sucesso.");
    }

    //todo Método para mudar diretor da escola
    protected void mudarDiretorMenu(Escola escola) {
        System.out.print("Digite o nome do diretor: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a idade do diretor: ");
        int idade = Integer.parseInt(scanner.nextLine());

        System.out.print("Digite o telefone do diretor: ");
        String telefone = scanner.nextLine();

        System.out.print("Digite o salário do diretor: ");
        double salario = Double.parseDouble(scanner.nextLine());

        System.out.print("Digite o email do diretor: ");
        String email = scanner.nextLine();

        Diretor novoDiretor = new Diretor(nome, idade, telefone, salario, email);
        escola.mudarDiretor(novoDiretor);
        System.out.println("Diretor trocado com sucesso.");
    }
}