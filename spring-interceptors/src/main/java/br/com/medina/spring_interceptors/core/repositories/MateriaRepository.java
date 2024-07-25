package br.com.medina.spring_interceptors.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.medina.spring_interceptors.core.models.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Integer> {
}
