package com.example.miniproject_funbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class bollywood_4 extends AppCompatActivity {
    RadioButton b4_r1,b4_r2,b4_r3,b4_r4;
    Button b4_next,b4_hint;
    int score=0;
    TextView b4_score;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bollywood4);
        b4_r1=(RadioButton) findViewById(R.id.b4_r1);
        b4_r2=(RadioButton) findViewById(R.id.b4_r2);
        b4_r3=(RadioButton) findViewById(R.id.b4_r3);
        b4_r4=(RadioButton) findViewById(R.id.b4_r1);
        b4_next=(Button) findViewById(R.id.b4_next);
        b4_hint=(Button) findViewById(R.id.b4_hint);
        b4_score=(TextView) findViewById(R.id.b4_score);
        Bundle b4=getIntent().getExtras();
        score=b4.getInt("score");
        username=b4.getString("username");
        b4_score.setText("Score: "+score);
        b4_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b4_r2.isChecked()){
                    score=score+10;
                    b4_score.setText("Score: "+score);
                    Intent b5=new Intent(getApplicationContext(),bollywood_5.class);
                    b5.putExtra("score",score);
                    b5.putExtra("username",username);
                    startActivity(b5);
                }
                else{
                    Toast.makeText(bollywood_4.this,"Oops!Wrong option selected",Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}