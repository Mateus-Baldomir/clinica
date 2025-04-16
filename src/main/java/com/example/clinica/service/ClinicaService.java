package com.example.clinica.service;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.clinica.model.DadosClinica;
import com.example.clinica.model.Especialidade;
import com.example.clinica.model.Profissional;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;

@Service
public class ClinicaService {

    private DadosClinica dadosClinica;

    @PostConstruct
    public void init() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = getClass().getResourceAsStream("/profissionais.json");
            this.dadosClinica = mapper.readValue(inputStream, DadosClinica.class);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar dados da clínica", e);
        }
    }

    public List<String> getEspecialidades() {
        return dadosClinica.getEspecialidades()
                .stream()
                .map(Especialidade::getNome)
                .collect(Collectors.toList());
    }

    public List<Profissional> getTodosProfissionais() {
        return dadosClinica.getEspecialidades()
                .stream()
                .flatMap(e -> e.getProfissionais().stream())
                .collect(Collectors.toList());
    }

    public List<Profissional> getPorEspecialidade(String especialidade) {
        return dadosClinica.getEspecialidades()
                .stream()
                .filter(e -> e.getNome().equalsIgnoreCase(especialidade))
                .flatMap(e -> e.getProfissionais().stream())
                .collect(Collectors.toList());
    }

    public List<Profissional> buscarPorNome(String nome) {
        return getTodosProfissionais()
                .stream()
                .filter(p -> p.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(Collectors.toList());
    }
}