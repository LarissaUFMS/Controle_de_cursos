package com.t2.controle_cursos.views;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.os.Bundle;

import com.t2.controle_cursos.database.CursosOnline;
import com.t2.controle_cursos.databinding.ActivityAlunoViewBinding;
import com.t2.controle_cursos.databinding.ActivityCursoViewBinding;
import com.t2.controle_cursos.entities.Curso;
import com.t2.controle_cursos.entities.Aluno;
import com.t2.controle_cursos.entities.AlunoCurso;

import java.util.List;

public class AlunoView extends AppCompatActivity {
    private CursosOnline db;
    private ActivityAlunoViewBinding binding;
    private int dbAlunoID;
    private List<Curso> cursos;
    private Spinner spnCursos;
    private int dbCursoID;
    private Aluno dbAluno;
    private ArrayAdapter<Curso> cursosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAlunoViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = CursosOnline.getDatabase(getApplicationContext());
        spnCursos = binding.spnCursos;
        dbAlunoID = getIntent().getIntExtra(
                "ALUNO_SELECIONADO_ID", -1);

    }

    private void preencheAluno() {
        dbAluno = db.alunoModel().getAluno(dbAlunoID);
        binding.edtAluno.setText(dbAluno.getNomeAluno());
        binding.edtEmail.setText(dbAluno.getEmailAluno());
        binding.edtTelefone.setText(dbAluno.getTelefoneAluno());
    }

    private void preencheCursos() {
        cursos = db.cursoModel().getAll();
        cursosAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, cursos);
        spnCursos.setAdapter(cursosAdapter);
        if(dbAluno != null) {
            spnCursos.setSelection(dbAluno.getCursoID() - 1);
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        if(dbAlunoID >= 0){
            preencheAluno();
        } else {
            binding.btnExcluirAluno.setVisibility(View.GONE);
        }
        preencheCursos();
    }

    public void salvarAluno(View view) {
        String aluno = binding.edtAluno.getText().toString();
        String email = binding.edtEmail.getText().toString();
        String telefone = binding.edtTelefone.getText().toString();

        String novoCurso = "";

        if(spnCursos.getSelectedItem() != null){
            novoCurso = spnCursos.getSelectedItem().toString();
        }
        if(aluno.equals("")){
            Toast.makeText(this, "O nome do aluno é obrigatório", Toast.LENGTH_SHORT).show();
            return;
        }
        if(novoCurso.equals("")) {
            Toast.makeText(this, "Entre com um Curso.", Toast.LENGTH_SHORT).show();
            return;
        }

        Aluno novoAluno = new Aluno();
        novoAluno.setNomeAluno(aluno);
        novoAluno.setCursoID(cursos.get(
                spnCursos.getSelectedItemPosition()).getCursoID());
        novoAluno.setEmailAluno(email);
        novoAluno.setTelefoneAluno(telefone);
        if(dbAluno != null){
            novoAluno.setAlunoID(dbAlunoID);
            db.alunoModel().update(novoAluno);
            Toast.makeText(this, "Aluno atualizado com sucesso.",
                    Toast.LENGTH_SHORT).show();
        } else {
            db.alunoModel().insertAll(novoAluno);
            Toast.makeText(this, "Aluno cadastrado com sucesso.",
                    Toast.LENGTH_SHORT).show();
        }
        finish();
    }

    public void excluirAluno(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Exclusão de Aluno")
                .setMessage("Deseja excluir esse aluno?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        excluir();
                    }
                })
                .setNegativeButton("Não", null)
                .show();
    }

    public void excluir() {
        db.alunoModel().delete(dbAluno);
        Toast.makeText(this, "Aluno excluído com sucesso.", Toast.LENGTH_SHORT).show();
        finish();
    }
    public void voltar(View view) {
        finish();
    }


}