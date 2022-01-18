package com.example.miniproject_funbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1=(Button) findViewById(R.id.b1);
        Button b2=(Button) findViewById(R.id.b2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startgame=new Intent(getApplicationContext(),bollywood_1.class);
                startgame.putExtra("score",0);
                startgame.putExtra("username","Madiha");
                startActivity(startgame);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b1=new Intent(getApplicationContext(),sign_up.class);
                startActivity(b1);
            }
        });
    }
}