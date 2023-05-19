package com.t2.controle_cursos.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;

import com.t2.controle_cursos.dao.AlunoCursoDao;
import com.t2.controle_cursos.dao.AlunoDao;
import com.t2.controle_cursos.dao.CursoDao;
import com.t2.controle_cursos.entities.Aluno;
import com.t2.controle_cursos.entities.Curso;

@Database(entities = {Curso.class, Aluno.class}, version = 1)
public class LocalDatabase {
    private static LocalDatabase INSTANCE;
    public static LocalDatabase getDatabase(Context context) {
        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    LocalDatabase.class, "ControleCursos").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
    public abstract AlunoDao celularModel();
    public abstract CursoDao marcaModel();
    public abstract AlunoCursoDao celularMarcaModel();
}
