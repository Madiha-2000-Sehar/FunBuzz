package com.example.miniproject_funbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login extends AppCompatActivity {

    Button lb;
    EditText u,p;
    DatabaseHelper db;
    String username;
    String password;
    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db=new DatabaseHelper(this);
        u=(EditText) findViewById(R.id.u);
        p=(EditText) findViewById(R.id.p);
        //confirmpassword=(EditText) findViewById(R.id.confirmpassword);
        lb=(Button) findViewById(R.id.lb);
        //load=(Button) findViewById(R.id.load);
        //res=(TextView) findViewById(R.id.res);
        lb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}