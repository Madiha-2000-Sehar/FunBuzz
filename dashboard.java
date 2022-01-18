package com.example.miniproject_funbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
public class dashboard extends AppCompatActivity {
    DatabaseHelper db;
    TextView tv1, tv2;
    String val = "";
    String username;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        db = new DatabaseHelper(this);
        //tv1 = (TextView) findViewById(R.id.tv1);
        //tv2 = (TextView) findViewById(R.id.tv2);
        Bundle b3 = getIntent().getExtras();
        score = b3.getInt("score");
        username = b3.getString("username");
        //Toast.makeText(dashboard.this,"yippe",Toast.LENGTH_LONG).show();
        //b5_score.setText("Score: "+score);
        //boolean status=db.update(username,score);
        //Toast.makeText(dashboard.this,"name"+status,Toast.LENGTH_LONG).show();
        int status = db.update(username, score);
        //Toast.makeText(dashboard.this, "count:" + status, Toast.LENGTH_LONG).show();
        Cursor c = db.select();
        if (c.getCount() == 0)
            Toast.makeText(dashboard.this, "No data", Toast.LENGTH_LONG).show();
        else {
            Toast.makeText(dashboard.this, "count:" + c.getCount(), Toast.LENGTH_LONG).show();
            //res.setText(c.getCount());
            //StringBuffer buf = new StringBuffer();
            //StringBuffer buf=new StringBuffer();
            //int i=1;
            while (c.moveToNext()) {

                int sc = c.getInt(3);
                String name = c.getString(1);
            /*if(i==1) {
                Toast.makeText(dashboard.this,"inside loop",Toast.LENGTH_LONG).show();
                val = "    " + val + name + "\t\t\t\t\t\t\t\t" + sc + "\n";
                tv1.setText(val);
           }*/

                //Toast.makeText(dashboard.this, "c is not null", Toast.LENGTH_LONG).show();
                //c.moveToNext();
                //Toast.makeText(dashboard.this, "c is moved to next" + c.getString(2), Toast.LENGTH_LONG).show();

                //Toast.makeText(dashboard.this, "name" + c.getString(2), Toast.LENGTH_LONG).show();
                //Toast.makeText(dashboard.this, "score" + c.getInt(3), Toast.LENGTH_LONG).show();
           /* else if(i==2){
                val = "    "+val + name + "\t\t\t\t\t\t\t\t" + sc + "\n";
                tv2.setText(val);
            }
            i++;*/
                //Toast.makeText(dashboard.this,"name"+val,Toast.LENGTH_LONG).show();
                val = val + name +"\t\t\t\t\t" + sc + "\n";
                //}
                Toast.makeText(dashboard.this, "Leader Board" + val, Toast.LENGTH_LONG).show();
                // tv1.setText("" + val);
                // }
            }
        }
    }
}
