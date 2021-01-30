package com.aula.appexame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edtName, edtTest1, edtTest2;
    Button btnApp, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtName =findViewById(R.id.edt_name);
        edtTest1 =findViewById(R.id.edt_teste1);
        edtTest2 =findViewById(R.id.edt_teste2);

        btnApp = findViewById(R.id.btn_edtAdd);
        btnCancel = findViewById(R.id.btn_edtCancel);

        btnApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameSend = edtName.getText().toString();
                String test1 = edtTest1.getText().toString();
                String test2 = edtTest2.getText().toString();

                if(nameSend.isEmpty() || test1.isEmpty() || test2.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Nao pode conter campos em brancos",Toast.LENGTH_SHORT).show();
                }else {
                    Integer test1Send = Integer.parseInt(edtTest1.getText().toString());
                    Integer test2Send = Integer.parseInt(edtTest2.getText().toString());
                    Integer media = (test1Send+test2Send)/2;


                    if (media >= 12){
                        Intent intentApp = new Intent(getApplicationContext(),ApprovedActivity.class);
                        intentApp.putExtra("nameCreateRegister", nameSend);
                        intentApp.putExtra("avaliacaoCreateRegister", "Approved");
                        intentApp.putExtra("mediaCreateRegister", media.toString());
                        startActivity(intentApp);
                        finish();

                    }else {
                        Intent intentExam = new Intent(getApplicationContext(), ExamActivity.class);
                        intentExam.putExtra("nameCreateRegister", nameSend);
                        intentExam.putExtra("avaliacaoCreateRegister", "Exam");
                        intentExam.putExtra("mediaCreateRegister", media.toString());
                        startActivity(intentExam);
                        finish();
                    }
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}