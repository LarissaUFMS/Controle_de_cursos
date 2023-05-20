package com.t2.controle_cursos.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.t2.controle_cursos.database.CursosOnline;
import com.t2.controle_cursos.databinding.ActivityCursoListBinding;
import com.t2.controle_cursos.entities.Curso;

import java.util.List;

public class CursoList extends AppCompatActivity {

    private ActivityCursoListBinding binding;
    private CursosOnline db;
    private List<Curso> cursos;
    private ListView listViewCursos;
    private Intent edtIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCursoListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = com.t2.controle_cursos.database.CursosOnline.getDatabase(getApplicationContext());
        listViewCursos = binding.listCursos;

        binding.btnHomeCurso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CursoList.this, CursoView.class));
            }
        });
    }
}