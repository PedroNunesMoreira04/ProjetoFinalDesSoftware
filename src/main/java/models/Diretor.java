package models;

import java.io.Serializable;

public class Diretor extends Funcionario implements Serializable {
    public Diretor(String nome, int idade, String numeroTelefone, double salario, String email) {
        super(nome, idade, numeroTelefone, salario, email);
    }

    //todo Override de toString para mostrar informações da classe
    @Override
    public String toString() {
        return "Diretor: " + super.toString();
    }
}
