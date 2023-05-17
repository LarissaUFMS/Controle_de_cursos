package com.t2.controle_cursos.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.t2.controle_cursos.entities.Curso;

import java.util.List;

@Dao
public interface CursoDao {
    @Query("SELECT * FROM cursos")
    List<Curso> getAll();
    @Insert
    void insertAll(Curso... cursos);
    @Update
    void update(Curso curso);
    @Delete
    void delete(Curso curso);
}
