package models;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Escola implements Serializable {
    private String nome;
    private Diretor diretor;
    private List<Professor> professores;
    private List<Aluno> alunos;
    private List<String> disciplinas;

    public Escola(String nome) {
        this.nome = nome;
        this.professores = new ArrayList<>();
        this.alunos = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
    }

    //todo Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public List<String> getDisciplinas() {
        return disciplinas;
    }

    //todo Métodos da escola
    public void exibirInformacoesBasicas() {
        System.out.println("\n=== Informações da Escola " + nome + " ===");
        System.out.println("\nDiretor:");
        if (diretor != null) {
            System.out.println(diretor.toString());  // Mostra todas as informações do diretor
        } else {
            System.out.println("Nenhum diretor definido");
        }

        System.out.println("\nResumo:");
        System.out.println("- Quantidade de Alunos: " + alunos.size());
        System.out.println("- Quantidade de Professores: " + professores.size());
        System.out.println("- Quantidade de Disciplinas: " + disciplinas.size());
    }

    //todo Método que lista professores
    public void listarProfessores() {
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
        } else {
            System.out.println("Lista de Professores:");
            for (Professor professor : professores) {
                System.out.println(professor);
            }
        }
    }

    //todo Método que lista alunos
    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("Lista de Alunos:");
            for (Aluno aluno : alunos) {
                System.out.println(aluno);
            }
        }
    }

    //todo Método que lista disciplinas
    public void listarDisciplinas() {
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
        } else {
            System.out.println("Lista de Disciplinas:");
            for (String disciplina : disciplinas) {
                System.out.println("- " + disciplina);
            }
        }
    }

    //todo Métodos que adicionam e removem elementos das listas
    public void adicionarDisciplina(String disciplina) {
        disciplinas.add(disciplina);
    }

    public boolean removerDisciplina(String disciplina) {
        return disciplinas.remove(disciplina);
    }

    public void adicionarProfessor(Professor professor) {
        professores.add(professor);
    }

    public boolean removerProfessor(Professor professor) {
        return professores.remove(professor);
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public boolean removerAluno(Aluno aluno) {
        return alunos.remove(aluno);
    }

    //todo Método que muda o diretor
    public void mudarDiretor(Diretor diretorNovo) {
        this.diretor = diretorNovo;
    }

    //todo Método que diz se possui professor na lista
    public boolean contemProfessor(String nomeProfessor) {
        for (Professor professor : professores) {
            if (professor.getNome().equalsIgnoreCase(nomeProfessor)) {
                return true;
            }
        }
        return false;
    }

    //todo Método que diz se possui aluno na lista
    public boolean contemAluno(String nomeAluno) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nomeAluno)) {
                return true;
            }
        }
        return false;
    }

    //todo Método que diz se possui disciplina na lista
    public boolean contemDisciplina(String disciplina) {
        return disciplinas.contains(disciplina);
    }

    //todo Método que retorna o objeto do professor pelo nome fornecido
    public Professor getProfessorPorNome(String nome) {
        for (Professor professor : professores) {
            if (professor.getNome().equalsIgnoreCase(nome)) {
                return professor;
            }
        }
        return null;
    }

    //todo Método que retorna o objeto do aluno pelo nome fornecido
    public Aluno getAlunoPorNome(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                return aluno;
            }
        }
        return null;
    }
}