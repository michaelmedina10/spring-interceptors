package br.com.medina.spring_interceptors.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.medina.spring_interceptors.adapters.dtos.AlunoDTO;
import br.com.medina.spring_interceptors.adapters.dtos.MateriaDTO;
import br.com.medina.spring_interceptors.core.models.Aluno;
import br.com.medina.spring_interceptors.core.models.Materia;
import br.com.medina.spring_interceptors.core.repositories.AlunoRepository;
import br.com.medina.spring_interceptors.core.repositories.MateriaRepository;

@Service
public class EscolaService {

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    MateriaRepository materiaRepository;

    public Aluno criarAluno(AlunoDTO alunoDTO) {

        Aluno aluno = alunoRepository.findAlunoByNome(alunoDTO.nome());

        if (aluno != null) {
            throw new RuntimeException("Aluno ja cadastrado");
        }

        Aluno newAluno = new Aluno(alunoDTO.nome(), alunoDTO.sobrenome(),
                alunoDTO.cpf(), alunoDTO.matricula());
        return alunoRepository.save(newAluno);
    }

    public MateriaDTO cadastrarNotaAluno(MateriaDTO materiaDTO) {

        Aluno aluno = alunoRepository.findAlunoByNome(materiaDTO.nomeAluno());

        if (aluno == null) {
            throw new RuntimeException("Aluno não cadastrado");
        }

        Materia materia = new Materia(materiaDTO.nomeMateria(), materiaDTO.nota(), aluno);
        Materia materiaCadastrada = materiaRepository.save(materia);
        return new MateriaDTO(materiaCadastrada.getNomeMateria(), materiaCadastrada.getNota(),
                materiaCadastrada.getAluno().getNome());

    }

    public List<Materia> getMateriasByAlunoNome(String nome) {
        return alunoRepository.findMateriasByAlunoNome(nome);
    }
}
