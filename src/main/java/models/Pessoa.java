package models;

import java.io.Serializable;

public abstract class Pessoa implements Serializable {
    private String nome;
    private int idade;
    private String numeroTelefone;

    public Pessoa(String nome, int idade, String numeroTelefone) {
        this.nome = nome;
        this.idade = idade;
        this.numeroTelefone = numeroTelefone;
    }

    //todo Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    //todo Serve para sumplificar o Override de classes filhas
    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Telefone: " + numeroTelefone;
    }
}
