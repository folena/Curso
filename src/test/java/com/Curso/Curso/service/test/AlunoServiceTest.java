package com.Curso.Curso.service.test;

import com.curso.curso.dto.AlunoDTO;
import com.Curso.Curso.entity.Aluno;
import com.Curso.Curso.entity.Endereco;
import com.Curso.Curso.repository.Aluno_Repository;
import com.Curso.Curso.service.AlunoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class AlunoServiceTest {

    @Mock
    private Aluno_Repository alunoRepository;

    @InjectMocks
    private AlunoService alunoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllAlunos() {
        // Configura dados de teste
        Aluno aluno1 = new Aluno(8.0, false, 5, false, false, new Endereco("Ibiuna", "SP", "18150-000"));
        Aluno aluno2 = new Aluno(9.0, true, 10, true, true, new Endereco("Sorocaba", "RJ", "12312-000"));
        List<Aluno> alunos = Arrays.asList(aluno1, aluno2);

        // Configura o mock do repositório
        when(alunoRepository.findAll()).thenReturn(alunos);

        // Executa o método de serviço
        List<AlunoDTO> resultado = alunoService.getAllAlunos();

        // Verifica o resultado
        assertThat(resultado).hasSize(2);
        assertThat(resultado.get(0).getCidade()).isEqualTo("Ibiuna");
        assertThat(resultado.get(1).getCidade()).isEqualTo("Sorocaba");

        // Verifica que o repositório foi chamado uma vez
        verify(alunoRepository, times(1)).findAll();
    }

    @Test
    public void testSaveAluno() {
        // Cria um AlunoDTO para teste
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setNota(8.5);
        alunoDTO.setCursosConcluidos(6);
        alunoDTO.setCidade("Ibiuna");
        alunoDTO.setEstado("SP");
        alunoDTO.setCep("18150-000");

        // Configura o mock do repositório para retornar o aluno salvo
        Aluno alunoParaSalvar = alunoDTO.toEntity();
        when(alunoRepository.save(any(Aluno.class))).thenReturn(alunoParaSalvar);

        // Executa o método de serviço
        AlunoDTO resultado = alunoService.saveAluno(alunoDTO);

        // Verifica o resultado
        assertThat(resultado).isNotNull();
        assertThat(resultado.getCidade()).isEqualTo("Ibiuna");
        assertThat(resultado.getNota()).isEqualTo(8.5);
        assertThat(resultado.getCep()).isEqualTo("18150-000");

        // Verifica que o repositório foi chamado uma vez com o aluno correto
        verify(alunoRepository, times(1)).save(any(Aluno.class));
    }
}
