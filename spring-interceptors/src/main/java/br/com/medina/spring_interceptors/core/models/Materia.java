package br.com.medina.spring_interceptors.core.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "materias")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome_materia")
    private String nomeMateria;

    private float nota;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    public Materia() {
    }

    public Materia(String nomeMateria, float nota, Aluno aluno) {
        this.nomeMateria = nomeMateria;
        this.nota = nota;
        this.aluno = aluno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeMateria() {
        return nomeMateria;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setNomeMateria(String nome) {
        this.nomeMateria = nome;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

}
