package com.Curso.Curso.test;

import com.Curso.Curso.entity.Aluno;
import com.Curso.Curso.entity.Endereco;
import com.Curso.Curso.repository.Aluno_Repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ActiveProfiles("test") // Perfil de teste para usar banco em memória H2
public class AlunoRepositoryTest {

    @Autowired
    private Aluno_Repository alunoRepository;

    @Test
    public void testSaveAndFindAluno() {
        // Cria um novo aluno com um endereço
        Endereco endereco = new Endereco("São Paulo", "SP", "01000-000");
        Aluno aluno = new Aluno(8.0, false, 5, false, false, endereco);

        // Salva o aluno no banco de dados
        Aluno savedAluno = alunoRepository.save(aluno);
        assertNotNull(savedAluno.getId(), "O ID do aluno salvo não deve ser nulo");

        // Busca o aluno pelo ID
        Optional<Aluno> retrievedAluno = alunoRepository.findById(savedAluno.getId());
        assertThat(retrievedAluno).isPresent();
        assertThat(retrievedAluno.get().getEndereco().getCidade()).isEqualTo("São Paulo");
    }

    @Test
    public void testAlunoNotaMaiorQue7RecebeCursosAdicionais() {
        // Cria e salva um aluno com nota maior que 7
        Aluno aluno = new Aluno();
        aluno.setNota(7.5);
        alunoRepository.save(aluno);

        // Valida que ele recebe cursos adicionais
        int cursosAdicionais = aluno.calcularCursosAdicionais();
        assertThat(cursosAdicionais).isEqualTo(3);
    }
}
