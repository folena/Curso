package com.Curso.Curso.service;

import com.curso.curso.dto.AlunoDTO;
import com.Curso.Curso.entity.Aluno;
import com.Curso.Curso.repository.Aluno_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    private Aluno_Repository alunoRepository;

    // Método para listar todos os alunos
    public List<AlunoDTO> getAllAlunos() {
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos.stream()
                     .map(AlunoDTO::fromEntity)
                     .collect(Collectors.toList());
    }

    // Método para salvar um novo aluno
    public AlunoDTO saveAluno(AlunoDTO alunoDTO) {
        Aluno aluno = alunoDTO.toEntity();
        Aluno savedAluno = alunoRepository.save(aluno);
        return AlunoDTO.fromEntity(savedAluno);
    }

    // Método para buscar um aluno pelo ID
    public AlunoDTO getAlunoById(Long id) {
        return alunoRepository.findById(id)
                              .map(AlunoDTO::fromEntity)
                              .orElse(null);
    }

    // Método para deletar um aluno pelo ID
    public void deleteAluno(Long id) {
        alunoRepository.deleteById(id);
    }

    // Outros métodos de lógica de negócio podem ser adicionados aqui
}
