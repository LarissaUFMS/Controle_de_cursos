package com.t2.controle_cursos.views;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Toast;

import com.t2.controle_cursos.database.CursosOnline;
import com.t2.controle_cursos.databinding.ActivityCursoViewBinding;

import com.t2.controle_cursos.entities.Curso;

public class CursoView extends AppCompatActivity {
    private CursosOnline db;
    private ActivityCursoViewBinding binding;
    private int dbCursoID;
    private Curso dbCurso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCursoViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = CursosOnline.getDatabase(getApplicationContext());
        dbCursoID = getIntent().getIntExtra(
                "CURSO_SELECIONADO_ID", -1);
    }
    protected void onResume() {
        super.onResume();
        if(dbCursoID >= 0) {
            getDBCurso();
        } else {
            binding.btnExcluirCurso.setVisibility(View.GONE);
        }
    }
    private void getDBCurso() {
        dbCurso = db.cursoModel().getCurso(dbCursoID);//relacionado a curodao
        binding.edtCurso.setText(dbCurso.getNomeCurso());//relacionado a curso
    }

    public void salvarCurso(View view) {
        String nomeCurso = binding.edtCurso.getText().toString();
        if (nomeCurso.equals("")) {
            Toast.makeText(this, "Adicione um curso.",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        Curso thisCurso = new Curso(nomeCurso);

        if (dbCurso != null) {
            thisCurso.setCursoID(dbCursoID);
            db.cursoModel().update(thisCurso);
            Toast.makeText(this, "Curso atualizado com sucesso.", Toast.LENGTH_SHORT).show();
        } else {
            db.cursoModel().insertAll(thisCurso);
            Toast.makeText(this, "Curso criado com sucesso.", Toast.LENGTH_SHORT).show();
        }
        finish();
    }

    public void excluirCurso(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Exclusão de Curso")
                .setMessage("Deseja excluir essa Curso?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        excluir();
                    }
                })
                .setNegativeButton("Não", null)
                .show();
    }

    private void excluir() {
        try {
            db.cursoModel().delete(dbCurso);
            Toast.makeText(this, "Curso excluído com sucesso", Toast.LENGTH_SHORT).show();
        } catch (SQLiteConstraintException e) {
            Toast.makeText(this, "Impossível excluir curso com celulares cadastrados", Toast.LENGTH_SHORT).show();
        }
        finish();
    }
    public void voltar(View view) {
        finish();
    }
}