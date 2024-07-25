package br.com.medina.spring_interceptors.adapters.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.medina.spring_interceptors.adapters.dtos.AlunoDTO;
import br.com.medina.spring_interceptors.adapters.dtos.MateriaAlunoDTO;
import br.com.medina.spring_interceptors.adapters.dtos.MateriaDTO;
import br.com.medina.spring_interceptors.application.EscolaService;
import br.com.medina.spring_interceptors.core.models.Aluno;
import br.com.medina.spring_interceptors.core.models.Materia;

@RestController
@RequestMapping(value = "/escola")
public class EscolaController {

    @Autowired
    EscolaService escolaService;

    @PostMapping("/aluno")
    public ResponseEntity<Aluno> criarAluno(@RequestBody AlunoDTO alunoDTO) {
        return ResponseEntity.ok().body(escolaService.criarAluno(alunoDTO));
    }

    @PostMapping("/materia")
    public ResponseEntity<MateriaDTO> cadastrarNotaMateria(@RequestBody MateriaDTO materiaDTO) {
        return ResponseEntity.ok().body(escolaService.cadastrarNotaAluno(materiaDTO));
    }

    @GetMapping("/{nome}/materias")
    public List<MateriaAlunoDTO> getMateriasByAlunoNome(@PathVariable String nome) {
        List<Materia> materias = escolaService.getMateriasByAlunoNome(nome);

        List<MateriaAlunoDTO> materiaAlunoDTO = new ArrayList<>();
        materias.forEach(materia -> materiaAlunoDTO.add(new MateriaAlunoDTO(
                materia.getNomeMateria(),
                materia.getNota(),
                materia.getAluno().getNome())));
        return materiaAlunoDTO;
    }
}
