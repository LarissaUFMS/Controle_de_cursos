package com.t2.controle_cursos.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.t2.controle_cursos.entities.AlunoCurso;

import java.util.List;


@Dao
public interface AlunoCursoDao {
    @Query("SELECT alunos.alunoID AS alunoID, alunos.nomeAluno " +
            "AS alunoNome, cursos.nomeCurso AS cursoName " +
            "FROM alunos INNER JOIN cursos ON alunos.cursoID = cursos.cursoID")
    List<AlunoCurso> getAllAlunoCurso();

}
