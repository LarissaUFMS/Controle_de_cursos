package com.t2.controle_cursos.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "alunos",
        foreignKeys = @ForeignKey(parentColumns = "cursoID", entity = Curso.class, childColumns = "cursoID", deferred = true ))
public class Aluno {
    @PrimaryKey(autoGenerate = true)
    int alunoID;
    String nomeAluno;

    int cursoID;
    String emailAluno;
    String telefoneAluno;

    //Inicío da declaração dos construtores
    public Aluno() {}

    public Aluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public Aluno(String nomeAluno, int cursoID) {
        this.nomeAluno = nomeAluno;
        this.cursoID = cursoID;
    }

    public Aluno(String nomeAluno, int cursoID, String emailAluno) {
        this.nomeAluno = nomeAluno;
        this.cursoID = cursoID;
        this.emailAluno = emailAluno;
    }
    public Aluno(String nomeAluno, int cursoID, String emailAluno, String telefoneAluno) {
        this.nomeAluno = nomeAluno;
        this.cursoID = cursoID;
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
