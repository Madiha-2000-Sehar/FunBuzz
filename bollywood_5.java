package com.example.miniproject_funbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class bollywood_5 extends AppCompatActivity {
    RadioButton b5_r1,b5_r2,b5_r3,b5_r4;
    Button b5_next,b5_hint;
    int score=0;
    TextView b5_score;
    DatabaseHelper db;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bollywood5);
        b5_r1=(RadioButton) findViewById(R.id.b5_r1);
        b5_r2=(RadioButton) findViewById(R.id.b5_r2);
        b5_r3=(RadioButton) findViewById(R.id.b5_r3);
        b5_r4=(RadioButton) findViewById(R.id.b5_r1);
        b5_next=(Button) findViewById(R.id.b4_next);
        b5_hint=(Button) findViewById(R.id.b4_hint);
        b5_score=(TextView) findViewById(R.id.b5_score);
        db=new DatabaseHelper(this);
        Bundle b3=getIntent().getExtras();
        score=b3.getInt("score");
        username=b3.getString("username");
        b5_score.setText("Score: "+score);
        b5_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b5_r3.isChecked()){
                    score=score+10;
                    b5_score.setText("Score: "+score);
                    //db.update(username,score);
                    //DatabaseHelper db=new DatabaseHelper(this);
                    Intent b4=new Intent(getApplicationContext(),h2.class);
                    b4.putExtra("score",score);
                    startActivity(b4);
                }
                else{
                    Toast.makeText(bollywood_5.this,"Oops!Wrong option selected",Toast.LENGTH_LONG).show();
                }


            }
        });
        b5_hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d=new Intent(getApplicationContext(),dashboard.class);
                d.putExtra("score",score);
                d.putExtra("username",username);
                startActivity(d);

            }
        });
    }
}