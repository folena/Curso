package com.Curso.Curso.controller;

import com.curso.curso.dto.AlunoDTO;
import com.Curso.Curso.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    // Endpoint para obter todos os alunos
    @GetMapping
    public ResponseEntity<List<AlunoDTO>> getAllAlunos() {
        List<AlunoDTO> alunos = alunoService.getAllAlunos();
        return ResponseEntity.ok(alunos);
    }

    // Endpoint para obter um aluno pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> getAlunoById(@PathVariable Long id) {
        AlunoDTO aluno = alunoService.getAlunoById(id);
        if (aluno != null) {
            return ResponseEntity.ok(aluno);
        }
        return ResponseEntity.notFound().build();
    }

    // Endpoint para criar um novo aluno
    @PostMapping
    public ResponseEntity<AlunoDTO> createAluno(@RequestBody AlunoDTO alunoDTO) {
        AlunoDTO novoAluno = alunoService.saveAluno(alunoDTO);
        return ResponseEntity.ok(novoAluno);
    }

    // Endpoint para atualizar um aluno existente
    @PutMapping("/{id}")
    public ResponseEntity<AlunoDTO> updateAluno(@PathVariable Long id, @RequestBody AlunoDTO alunoDTO) {
        AlunoDTO alunoExistente = alunoService.getAlunoById(id);
        if (alunoExistente != null) {
            alunoDTO.setId(id, id); // Garante que o ID existente será mantido na atualização
            AlunoDTO alunoAtualizado = alunoService.saveAluno(alunoDTO);
            return ResponseEntity.ok(alunoAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

    // Endpoint para deletar um aluno
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Long id) {
        AlunoDTO aluno = alunoService.getAlunoById(id);
        if (aluno != null) {
            alunoService.deleteAluno(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

