package com.aula.appexame;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.LinkedList;

public class ExamActivity extends AppCompatActivity {
    private final LinkedList<Aluno> AlunoList = new LinkedList<>();

    private RecyclerView mRecyclerView;
    private ApprovedAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        mRecyclerView = findViewById(R.id.recyclerview_content_main);

        Intent data = getIntent();
        String nameAlunoReceived = data.getStringExtra("nameCreateRegister");
        String avaliacaoAlunoReceived = data.getStringExtra("avaliacaoCreateRegister");
        String mediaoAlunoReceived = data.getStringExtra("mediaCreateRegister");

        //criar contacto
        Aluno newAluno = new Aluno(nameAlunoReceived, avaliacaoAlunoReceived, mediaoAlunoReceived);
        //Adicionar contacto
        AlunoList.add(newAluno);
        // Get a handle to the RecyclerView.
        // Create an adapter and supply the data to be displayed.
        mAdapter = new ApprovedAdapter(this, AlunoList);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 1:
                mAdapter.removerItem(item.getGroupId());
                return  true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}