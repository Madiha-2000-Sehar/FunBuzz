package com.example.miniproject_funbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.*;

public class sign_up extends AppCompatActivity {

    EditText username,password,confirmpassword;
    Button sign_up_b,load;
    DatabaseHelper db;
    String val="";
    TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        db=new DatabaseHelper(this);
        username=(EditText) findViewById(R.id.u);
       password=(EditText) findViewById(R.id.p);
        confirmpassword=(EditText) findViewById(R.id.confirmpassword);
       sign_up_b=(Button) findViewById(R.id.lb);
        //load=(Button) findViewById(R.id.load);
        res=(TextView) findViewById(R.id.res);
    }
    public void insert_call(View view){
        if(password.getText().toString().equals(confirmpassword.getText().toString())) {
            boolean status = db.insert(username.getText().toString(), password.getText().toString(), 0);
            Toast.makeText(sign_up.this, "login Successful!! Explore and have fun!! ", Toast.LENGTH_LONG).show();
            Intent q1=new Intent(getApplicationContext(),bollywood_1.class);
            q1.putExtra("username",username.getText().toString());
            q1.putExtra("score",0);
            startActivity(q1);
        }
        else{
            Toast.makeText(sign_up.this, "Passwords do not match", Toast.LENGTH_LONG).show();
        }
    }
    public void report(View view){
        Cursor c=db.select();
        if(c.getCount()==0)
            return;
        //res.setText(c.getCount());
        //StringBuffer buf = new StringBuffer();
        //StringBuffer buf=new StringBuffer();
        while(c.moveToNext()){
            int id=c.getInt(0);
            String name=c.getString(1);
            String pass=c.getString(2);
            int sc=c.getInt(3);
            val=val+name+pass+sc+"\n";
            Toast.makeText(sign_up.this,"name"+val,Toast.LENGTH_LONG).show();
            //val=val+name+pass+sc+"\n";
        }
        res.setText("Res"+val);
    }
}