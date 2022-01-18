package com.example.miniproject_funbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class bollywood_1 extends AppCompatActivity {


    RadioButton r1,r2,r3,r4;
    Button next1;
    TextView points;
    int score=0;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bollywood1);
        r1=(RadioButton) findViewById(R.id.r1);
        r2=(RadioButton) findViewById(R.id.r2);
        r3=(RadioButton) findViewById(R.id.r3);
        r4=(RadioButton) findViewById(R.id.r4);
        points=(TextView) findViewById(R.id.points);
        next1=(Button) findViewById(R.id.next1);
        Bundle b=getIntent().getExtras();
        score=b.getInt("score");
        username=b.getString("username");
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(r2.isChecked()){
                    score=score+10;
                    points.setText("Score: "+score);
                    Toast.makeText(bollywood_1.this,"Great! let's navigate to the next fun segment...",Toast.LENGTH_LONG).show();
                    Intent b2=new Intent(getApplicationContext(),bollywood_2.class);
                    b2.putExtra("score",score);
                    b2.putExtra("username",username);
                    startActivity(b2);
                }
                else{
                    Toast.makeText(bollywood_1.this,"Oops!Wrong option selected",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}