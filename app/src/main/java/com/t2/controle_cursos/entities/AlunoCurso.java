package com.t2.controle_cursos.entities;

public class AlunoCurso {
    public int alunoID;
    public String nomeAluno;
    public String nomeCurso;

    public int getAlunoID() {
        return alunoID;
    }
    @Override
    public String toString(){
        return this.alunoID + ": " + nomeAluno + "\nCurso: "+ nomeCurso;
    }
}
