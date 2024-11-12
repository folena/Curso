package com.Curso.Curso.test;

import com.Curso.Curso.entity.Aluno;
import com.Curso.Curso.entity.Endereco;
import com.Curso.Curso.repository.Aluno_Repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test") // Ativa o perfil de teste para usar banco de dados H2
public class AlunoIntegrationTest {

    @Autowired
    private Aluno_Repository alunoRepository;

    @Test
    public void testSalvarEEncontrarAluno() {
        // Cria um novo aluno com um endereço
        Endereco endereco = new Endereco("Rio de Janeiro", "RJ", "20000-000");
        Aluno aluno = new Aluno(9.0, false, 10, false, false, endereco);

        // Salva o aluno no banco de dados
        Aluno savedAluno = alunoRepository.save(aluno);
        assertNotNull(savedAluno.getId(), "O ID do aluno salvo não deve ser nulo");

        // Busca o aluno pelo ID
        Optional<Aluno> retrievedAluno = alunoRepository.findById(savedAluno.getId());
        assertTrue(retrievedAluno.isPresent(), "O aluno deve estar presente");
        assertEquals("Rio de Janeiro", retrievedAluno.get().getEndereco().getCidade());
    }

    @Test
    public void testAlunoDeveReceberCursoAdicionalSeForMaisAtivoNoForum() {
        // Cria um aluno e configura para ser o mais ativo no fórum
        Aluno aluno = new Aluno();
        aluno.setMaisContribuicoesNoForum(true);
        alunoRepository.save(aluno);

        // Verifica se o aluno ganha um curso adicional
        boolean ganhouCursoAdicional = aluno.verificarSeGanhouCursoAdicional();
        assertTrue(ganhouCursoAdicional, "O aluno deveria receber um curso adicional por sua atividade no fórum.");
    }

    @Test
    public void testAlunoDeveSerPromovidoParaPremiumApos12Cursos() {
        // Cria um aluno com 12 cursos concluídos
        Aluno aluno = new Aluno();
        aluno.setCursosConcluidos(12);
        aluno.setPremium(false);
        alunoRepository.save(aluno);

        // Verifica se o status premium foi ativado
        aluno.verificarStatusPremium();
        assertTrue(aluno.isPremium(), "O aluno deveria ser promovido para Premium após 12 cursos.");
    }
}
