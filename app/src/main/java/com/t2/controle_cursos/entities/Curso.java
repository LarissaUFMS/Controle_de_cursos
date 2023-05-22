package com.t2.controle_cursos.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cursos")
public class Curso {

    @PrimaryKey(autoGenerate = true)
    int cursoID;
    String nomeCurso;
    int qtdeHoras;

    //Inicío da declaração dos construtores
    public Curso() {}

    public Curso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    //Fim da declaração dos construtores

    //Início dos métodos get e set
    public int getCursoID() {
        return cursoID;
    }
    public String getNomeCurso() { return nomeCurso; }
    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }
    public int getQtdeHoras() {
        return qtdeHoras;
    }
    public void setQtdeHoras(int qtdeHoras) {
        this.qtdeHoras = qtdeHoras;
    }
    public void setCursoID(int cursoID) { this.cursoID = cursoID;}
    //Fim dos métodos get e set

    @Override
    public String toString() {
        return this.nomeCurso + " " + qtdeHoras + "h";
    }
}
