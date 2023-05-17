package com.t2.controle_cursos.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.t2.controle_cursos.entities.Aluno;

@Database(entities = {Aluno.class}, version = 1)
public abstract class CursosOnline extends RoomDatabase {
}
