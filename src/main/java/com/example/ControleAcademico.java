package com.example;

import java.util.ArrayList;
import java.util.List;

public class ControleAcademico {
    private List<Aluno> alunos;

    public ControleAcademico() {
        alunos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void removerAluno(int matricula) {
        alunos.removeIf(aluno -> aluno.getMatricula() == matricula);
    }

    public List<Aluno> listarAlunos() {
        return alunos;
    }
}
