package com.t2.controle_cursos.entities;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(parentColumns = "cursoID", entity = Curso.class, childColumns = "cursoID", onDelete = CASCADE))
public class Aluno {
    @PrimaryKey(autoGenerate = true)
    int alunoID;
    String nomeAluno;
    int cursoID;
    String emailAluno;
    String telefoneAluno;

    //Inicío da declaração dos construtores
    public Aluno() {}
    public Aluno(String nomeAluno, int cursoID) {
        this.nomeAluno = nomeAluno;
        this.cursoID = cursoID;
    }
    //Fim da declaração dos construtores

    //Início dos métodos get e set
    public int getAlunoID() { return alunoID; }

    public void setAlunoID(int alunoID) { this.alunoID = alunoID; }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public int getCursoID() { return cursoID; }

    public void setCursoID(int cursoID) { this.cursoID = cursoID; }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getEmailAluno() {
        return emailAluno;
    }

    public void setEmailAluno(String emailAluno) {
        this.emailAluno = emailAluno;
    }

    public String getTelefoneAluno() {
        return telefoneAluno;
    }

    public void setTelefoneAluno(String telefoneAluno) {
        this.telefoneAluno = telefoneAluno;
    }
    //Fim dos métodos get e set

    @Override
    public String toString() {
        return "Aluno{" + "alunoID=" + alunoID + ", nomeAluno='" + nomeAluno + '\'' + ", emailAluno='" + emailAluno + '\'' + ", telefoneAluno='" + telefoneAluno + '\'' + '}';
    }
}
