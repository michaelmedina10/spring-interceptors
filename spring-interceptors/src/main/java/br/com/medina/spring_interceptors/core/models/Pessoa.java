package br.com.medina.spring_interceptors.core.models;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Pessoa {
    private String nome;
    private String sobrenome;
    private String cpf;

    public Pessoa() {
    }

    public Pessoa(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}