package com.t2.controle_cursos.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Curso {

    @PrimaryKey(autoGenerate = true)
    int cursoID;
    String nomeCurso;
    int qtdeHoras;

}
