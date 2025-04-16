package com.example.clinica.model;

import java.util.List;

public class Especialidade {
    private String nome;
    private List<Profissional> profissionais;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<Profissional> getProfissionais() { return profissionais; }
    public void setProfissionais(List<Profissional> profissionais) { this.profissionais = profissionais; }
}