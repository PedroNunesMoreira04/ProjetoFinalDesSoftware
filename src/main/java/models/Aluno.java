package models;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Aluno extends Pessoa implements Serializable {
    private List<String> disciplinas;

    public Aluno(String nome, int idade, String numeroTelefone) {
        super(nome, idade, numeroTelefone);
        this.disciplinas = new ArrayList<>();
    }

    //todo Getters e Setters
    public List<String> getDisciplinas() {
        return disciplinas;
    }

    public void adicionarDisciplina(String disciplina) {
        this.disciplinas.add(disciplina);
    }

    public void removerDisciplina(String disciplina) {
        this.disciplinas.remove(disciplina);
    }

    //todo Override de toString para mostrar informações da classe
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(", Disciplinas: ");
        if (disciplinas.isEmpty()) {
            sb.append("Nenhuma disciplina matriculada");
        } else {
            sb.append(String.join(", ", disciplinas));
        }
        return sb.toString();
    }
}
