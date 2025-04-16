package com.example.clinica.model;

import java.util.List;

public class Profissional {
    private String nome;
    private String crm;
    private List<String> disponibilidade;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCrm() { return crm; }
    public void setCrm(String crm) { this.crm = crm; }

    public List<String> getDisponibilidade() { return disponibilidade; }
    public void setDisponibilidade(List<String> disponibilidade) { this.disponibilidade = disponibilidade; }
}