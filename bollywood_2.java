package com.example.miniproject_funbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class bollywood_2 extends AppCompatActivity {
    RadioButton b2_r1,b2_r2,b2_r3,b2_r4;
    Button b2_next,b2_hint;
    TextView b2_score;
    String username;
    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bollywood2);
        b2_r1=(RadioButton) findViewById(R.id.b2_r1);
        b2_r2=(RadioButton) findViewById(R.id.b2_r2);
        b2_r3=(RadioButton) findViewById(R.id.b2_r3);
        b2_r4=(RadioButton) findViewById(R.id.b2_r4);
        b2_next=(Button) findViewById(R.id.b2_next);
        //b2_hint=(Button) findViewById(R.id.b2_hint);
        b2_score=(TextView) findViewById(R.id.b2_score);
        Bundle b1=getIntent().getExtras();
        score=b1.getInt("score");
        username=b1.getString("username");
        b2_score.setText("Score: "+score);
        b2_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b2_r1.isChecked()){
                    score=score+10;
                    b2_score.setText("Score: "+score);
                    Intent b3=new Intent(getApplicationContext(),bollywood_3.class);
                    b3.putExtra("score",score);
                   // b2.putExtra("score",score);
                    b3.putExtra("username",username);
                    startActivity(b3);
                }
                else{
                    Toast.makeText(bollywood_2.this,"Oops!Wrong option selected",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}