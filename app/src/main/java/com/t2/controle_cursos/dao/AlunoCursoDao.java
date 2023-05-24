package com.t2.controle_cursos.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.t2.controle_cursos.entities.AlunoCurso;

import java.util.List;


@Dao
public interface AlunoCursoDao {
    @Query("SELECT Aluno.alunoID AS alunoID, Aluno.nomeAluno " +
            "AS nomeAluno, Curso.nomeCurso AS nomeCurso " +
            "FROM Aluno INNER JOIN Curso ON Aluno.cursoID = Curso.cursoID")
    List<AlunoCurso> getAllAlunoCurso();

}
