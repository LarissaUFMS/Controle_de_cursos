package com.t2.controle_cursos.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.t2.controle_cursos.R;

private LocalDatabase db;
public class AlunoList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_list);
    }
}