package com.t2.controle_cursos.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.t2.controle_cursos.entities.Aluno;

import java.util.List;
@Dao
public interface AlunoDao {
    @Query("SELECT * FROM alunos")
    List<Aluno> getAll();
    @Insert
    void insertAll(Aluno... alunos);
    @Update
    void update(Aluno aluno);
    @Delete
    void delete(Aluno aluno);
}
