package br.com.medina.spring_interceptors.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.medina.spring_interceptors.core.models.Aluno;
import br.com.medina.spring_interceptors.core.models.Materia;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    public Aluno findAlunoByNome(String nome);

    @Query("SELECT m FROM Materia m JOIN m.aluno a WHERE a.nome = :nome")
    List<Materia> findMateriasByAlunoNome(@Param("nome") String nome);
}
