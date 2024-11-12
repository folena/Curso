package com.Curso.Curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Curso.Curso.entity.Aluno;

@Repository
public interface Aluno_Repository extends JpaRepository<Aluno, Long> {
}
