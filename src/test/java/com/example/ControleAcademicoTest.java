package com.example;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ControleAcademicoTest {
    private ControleAcademico controleAcademico;

    @Before
    public void setUp() {
        controleAcademico = new ControleAcademico();
    }

    @Test
    public void testRemoverAluno() {
        // Crie um mock para a instância de ControleAcademico
        ControleAcademico controleAcademicoMock = mock(ControleAcademico.class);

        // Configurar o mock para retornar uma lista de alunos com 0 elementos
        when(controleAcademicoMock.listarAlunos()).thenReturn(Arrays.asList());

        // Configure o mock para remover o aluno com ID 456
        controleAcademicoMock.removerAluno(456);

        // Verifique se o método foi chamado exatamente uma vez
        verify(controleAcademicoMock, times(1)).removerAluno(456);

        // Agora, você pode verificar o estado da instância real
        List<Aluno> alunos = controleAcademico.listarAlunos();
        assertEquals(0, alunos.size());
    }
    
    @Test
    public void testRemoverAlunoComIdIncorreto() {
        // Crie um mock para a instância de ControleAcademico
        ControleAcademico controleAcademicoMock = mock(ControleAcademico.class);

        // Configurar o mock para retornar uma lista de alunos com 0 elementos
        when(controleAcademicoMock.listarAlunos()).thenReturn(Arrays.asList());

        // Configure o mock para remover o aluno com ID 123 (diferente do esperado)
        controleAcademicoMock.removerAluno(123);

        // Verifique se o método foi chamado exatamente uma vez
        verify(controleAcademicoMock, times(1)).removerAluno(456);

        // Agora, você pode verificar o estado da instância real
        List<Aluno> alunos = controleAcademico.listarAlunos();
        assertEquals(0, alunos.size());
    }

    // Restante dos testes
}
