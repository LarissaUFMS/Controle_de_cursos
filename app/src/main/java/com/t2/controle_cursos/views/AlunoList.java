package com.t2.controle_cursos.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.t2.controle_cursos.database.CursosOnline;
import com.t2.controle_cursos.databinding.ActivityAlunoListBinding;
import com.t2.controle_cursos.databinding.ActivityCursoListBinding;
import com.t2.controle_cursos.entities.Aluno;
import com.t2.controle_cursos.entities.AlunoCurso;
import com.t2.controle_cursos.entities.Curso;

import java.util.List;

public class AlunoList extends AppCompatActivity {

    private ActivityAlunoListBinding binding;
    private CursosOnline db;
    private List<AlunoCurso> cursoAluno;
    private ListView listViewAluno;
    private Intent edtIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAlunoListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = CursosOnline.getDatabase(getApplicationContext());
        listViewAluno = binding.listAluno;

        binding.btnHomeAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.btnAddAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AlunoList.this, AlunoView.class));
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        edtIntent = new Intent(this, AlunoView.class);
        preencheAlunos();
    }
    private void preencheAlunos() {
        cursoAluno = db.alunoCursoModel().getAllAlunoCurso();
        ArrayAdapter<AlunoCurso> cursoAlunoAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, cursoAluno);
        listViewAluno.setAdapter(cursoAlunoAdapter);

        listViewAluno.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                AlunoCurso alunoselecionado = cursoAluno.get(position);
                edtIntent.putExtra("ALUNO_SELECIONADO_ID",
                        alunoselecionado.getAlunoID());
                startActivity(edtIntent);
            }
        });
    }

}