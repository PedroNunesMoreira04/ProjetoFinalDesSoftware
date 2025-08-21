package models;

import java.io.Serializable;

public abstract class Funcionario extends Pessoa implements Serializable {
    private double salario;
    private String email;

    public Funcionario(String nome, int idade, String numeroTelefone, double salario, String email) {
        super(nome, idade, numeroTelefone);
        this.salario = salario;
        this.email = email;
    }

    //todo Getters e Setters
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //todo Serve para sumplificar o Override de classes filhas
    @Override
    public String toString() {
        return super.toString() + ", Salário: " + salario + ", Email: " + email;
    }
}