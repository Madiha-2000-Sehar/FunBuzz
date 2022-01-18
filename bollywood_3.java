package com.example.miniproject_funbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class bollywood_3 extends AppCompatActivity {
    RadioButton b3_r1,b3_r2,b3_r3,b3_r4;
    Button b3_next,b3_hint;
    int score=0;
    TextView b3_score;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bollywood3);
        b3_r1=(RadioButton) findViewById(R.id.b3_r1);
        b3_r2=(RadioButton) findViewById(R.id.b3_r2);
        b3_r3=(RadioButton) findViewById(R.id.b3_r3);
        b3_r4=(RadioButton) findViewById(R.id.b3_r1);
        b3_next=(Button) findViewById(R.id.b3_next);
        //b3_hint=(Button) findViewById(R.id.b3_hint);
        b3_score=(TextView) findViewById(R.id.b3_score);
        Bundle b3=getIntent().getExtras();
        score=b3.getInt("score");
        username=b3.getString("username");
        b3_score.setText("Score: "+score);
        b3_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b3_r3.isChecked()){
                    score=score+10;
                    b3_score.setText("Score: "+score);
                    Intent b4=new Intent(getApplicationContext(),bollywood_4.class);
                    b4.putExtra("score",score);
                    b4.putExtra("username",username);
                    startActivity(b4);
                }
                else{
                    Toast.makeText(bollywood_3.this,"Oops!Wrong option selected",Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}