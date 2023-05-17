package com.t2.controle_cursos.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class Aluno {
    @PrimaryKey(autoGenerate = true)
    int alunoID;

    @ForeignKey(entity = Curso.class, parentColumns = "cursoID", childColumns = "cursoID", deferred = true )
    int cursoID;
    String nomeAluno;
    String emailAluno;
    String telefoneAluno;

    //Inicío da declaração dos construtores
    public Aluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public Aluno(String nomeAluno, String emailAluno) {
        this.nomeAluno = nomeAluno;
        this.emailAluno = emailAluno;
    }

    public Aluno(String nomeAluno, String emailAluno, String telefoneAluno) {
        this.nomeAluno = nomeAluno;
        this.emailAluno = emailAluno;
        this.telefoneAluno = telefoneAluno;
    }
    //Fim da declaração dos construtores

    //Início dos métodos get e set
    public int getAlunoID() {
        return alunoID;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

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
        return "Aluno{" +
                "alunoID=" + alunoID +
                ", nomeAluno='" + nomeAluno + '\'' +
                ", emailAluno='" + emailAluno + '\'' +
                ", telefoneAluno='" + telefoneAluno + '\'' +
                '}';
    }
}
