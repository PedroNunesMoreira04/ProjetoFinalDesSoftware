package models;

import java.io.Serializable;

public class Professor extends Funcionario implements Serializable {
    private String disciplina;

    public Professor(String nome, int idade, String numeroTelefone, double salario, String email, String disciplina) {
        super(nome, idade, numeroTelefone, salario, email);
        this.disciplina = disciplina;
    }

    //todo Getters e Setters
    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    //todo Override de toString para mostrar informações da classe
    @Override
    public String toString() {
        return super.toString() + ", Disciplina: " + disciplina;
    }
}
