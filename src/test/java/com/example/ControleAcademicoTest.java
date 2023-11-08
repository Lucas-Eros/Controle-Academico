package com.example;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;

public class ControleAcademicoTest {
    private ControleAcademico controleAcademico;

    @Before
    public void setUp() {
        controleAcademico = new ControleAcademico();
    }

    @Test
    public void testListarAlunosEmOrdem() {
        // Criando o mock de ControleAcademico
        ControleAcademico controleAcademicoMock = mock(ControleAcademico.class);

        Aluno aluno1 = new Aluno("Lucas", 789);
        Aluno aluno2 = new Aluno("Ana", 101);

        // Configurando o mock para adicionar alunos
        when(controleAcademicoMock.listarAlunos())
            .thenReturn(Arrays.asList(aluno1, aluno2));

        // Realizando a operação que você deseja testar
        List<Aluno> alunos = controleAcademicoMock.listarAlunos();

        // Verificando a ordem em que os métodos foram chamados no mock
        InOrder inOrder = inOrder(controleAcademicoMock);
        inOrder.verify(controleAcademicoMock).listarAlunos();

        List<Aluno> expectedAlunos = Arrays.asList(aluno1, aluno2);

        assertEquals(expectedAlunos, alunos);
    }

    @Test
    public void testExcecaoAoRemoverAlunoInexistente() {
        // Criando um mock para a instância de ControleAcademico
        ControleAcademico controleAcademicoMock = mock(ControleAcademico.class);

        // Configurando o mock para lançar uma exceção ao tentar remover um aluno inexistente
        doThrow(new RuntimeException("Aluno não encontrado")).when(controleAcademicoMock).removerAluno(123);

        // Verificando se a exceção é lançada
        try {
            controleAcademicoMock.removerAluno(123);
        } catch (RuntimeException e) {
            assertEquals("Aluno não encontrado", e.getMessage());
        }
    }

    @Test
    public void testCapturarArgumentoAoAdicionarAluno() {
        // Crie um mock de ControleAcademico
        ControleAcademico controleAcademicoMock = mock(ControleAcademico.class);

        Aluno aluno = new Aluno("João", 123);

        // Realize a operação que você deseja testar
        controleAcademicoMock.adicionarAluno(aluno);

        // Criando um capturador de argumento
        ArgumentCaptor<Aluno> captor = ArgumentCaptor.forClass(Aluno.class);

        // Verificando se o método foi chamado com o argumento esperado
        verify(controleAcademicoMock).adicionarAluno(captor.capture());
        assertEquals(aluno, captor.getValue());
    }
}

