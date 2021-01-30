package com.aula.appexame;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.LinkedList;


public class MainActivity extends AppCompatActivity {

    private Button btn_approved, btn_exam, btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btn_approved = findViewById(R.id.btn_Approved);
        btn_exam = findViewById(R.id.btn_Exam);
        btn_register = findViewById(R.id.btn_Register);

        btn_approved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentApproved = new Intent(getApplicationContext(), ApprovedActivity.class);
                startActivity(intentApproved);
            }
        });

        btn_exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentExam = new Intent(getApplicationContext(), ExamActivity.class);
                startActivity(intentExam);
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intentReg);
            }
        });
    }



}