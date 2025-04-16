package com.example.clinica.controller;

import com.example.clinica.model.Profissional;
import com.example.clinica.service.ClinicaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClinicaController {

    private final ClinicaService service;

    public ClinicaController(ClinicaService service) {
        this.service = service;
    }

    @GetMapping("/especialidades")
    public List<String> listarEspecialidades() {
        return service.getEspecialidades();
    }

    @GetMapping("/profissionais")
    public List<Profissional> listarProfissionais(
            @RequestParam(required = false) String especialidade,
            @RequestParam(required = false) String nome
    ) {
        if (especialidade != null) {
            return service.getPorEspecialidade(especialidade);
        } else if (nome != null) {
            return service.buscarPorNome(nome);
        } else {
            return service.getTodosProfissionais();
        }
    }
}