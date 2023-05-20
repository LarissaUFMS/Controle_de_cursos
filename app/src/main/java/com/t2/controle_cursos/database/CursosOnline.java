package com.t2.controle_cursos.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.t2.controle_cursos.dao.AlunoCursoDao;
import com.t2.controle_cursos.dao.AlunoDao;
import com.t2.controle_cursos.dao.CursoDao;
import com.t2.controle_cursos.entities.Aluno;
import com.t2.controle_cursos.entities.Curso;

@Database(entities = {Curso.class, Aluno.class}, version = 1)
public abstract class CursosOnline extends RoomDatabase {
    private static CursosOnline INSTANCE;
    public static CursosOnline getDatabase(Context context) {
        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    CursosOnline.class,
                    "ControleCursos").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
    public abstract AlunoDao alunoModel();
    public abstract CursoDao cursoModel();
    public abstract AlunoCursoDao alunoCursoModel();
}
