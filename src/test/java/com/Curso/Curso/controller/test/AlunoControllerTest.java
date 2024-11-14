package com.Curso.Curso.controller.test;

import com.curso.curso.dto.AlunoDTO;
import com.Curso.Curso.controller.AlunoController;
import com.Curso.Curso.service.AlunoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AlunoController.class)
public class AlunoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AlunoService alunoService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllAlunos() throws Exception {
        // Configura dados de teste
        AlunoDTO aluno1 = new AlunoDTO();
        aluno1.setNota(8.0);
        aluno1.setCidade("São Paulo");

        AlunoDTO aluno2 = new AlunoDTO();
        aluno2.setNota(9.5);
        aluno2.setCidade("Rio de Janeiro");

        List<AlunoDTO> alunos = Arrays.asList(aluno1, aluno2);

        // Configura o mock para retornar a lista de alunos
        when(alunoService.getAllAlunos()).thenReturn(alunos);

        // Realiza a requisição GET e verifica o resultado
        mockMvc.perform(get("/alunos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nota").value(8.0))
                .andExpect(jsonPath("$[0].cidade").value("São Paulo"))
                .andExpect(jsonPath("$[1].nota").value(9.5))
                .andExpect(jsonPath("$[1].cidade").value("Rio de Janeiro"));
    }

    @Test
    public void testCreateAluno() throws Exception {
        // Cria o DTO para a requisição de criação de um aluno
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setNota(8.5);
        alunoDTO.setCidade("Curitiba");
        alunoDTO.setEstado("PR");
        alunoDTO.setCep("80000-000");

        // Configura o mock para retornar o aluno salvo
        when(alunoService.saveAluno(Mockito.any(AlunoDTO.class))).thenReturn(alunoDTO);

        // Realiza a requisição POST e verifica o resultado
        mockMvc.perform(post("/alunos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(alunoDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nota").value(8.5))
                .andExpect(jsonPath("$.cidade").value("Curitiba"))
                .andExpect(jsonPath("$.estado").value("PR"))
                .andExpect(jsonPath("$.cep").value("80000-000"));
    }
}
