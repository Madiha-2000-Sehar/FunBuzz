package com.example.miniproject_funbuzz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Toast;


public class DatabaseHelper extends SQLiteOpenHelper{
    DatabaseHelper(Context context){
        super(context, "Fun.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE POINTS ( UID INTEGER PRIMARY KEY AUTOINCREMENT, UNAME TEXT, UPASSWORD TEXT, SCORE INTEGER);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS POINTS ");
        onCreate(sqLiteDatabase);

    }
    public boolean insert(String name,String pass,int score){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("UNAME", name);
        cv.put("UPASSWORD", pass);
        cv.put("SCORE", score);
        long status = db.insert("POINTS",null,cv);
        if(status == -1)
            return false;
        else
            return true;
    }
    public Cursor select(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cr=db.rawQuery("SELECT * FROM POINTS", null);
        return cr;
    }
    public Cursor selectuser(String username,String password){
        SQLiteDatabase db = this.getReadableDatabase();
        String query="SELECT * FROM POINTS WHERE UNAME= "+username+" AND UPASSWORD= "+password;
        Cursor cr=db.rawQuery(query, null);
        return cr;
    }
    public int update(String username, int score) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        //cv.put();
        //cv.put("UNAME", username);
        //cv.put("UPASSWORD", pass);
       cv.put("SCORE", score);
        //String query="UPDATE POINTS SET SCORE = " + score + " WHERE UNAME= " + username;
        //db.execSQL(query);
        //int sc=score.toStirng();
        int status = db.update("POINTS", cv, "UNAME=?", new String[]{ username });
        //Toast.makeText(DatabaseHelper.this, "hey", Toast.LENGTH_LONG).show();
        /*if(update==-1){
            Toast.makeText(DatabaseHelper.this,"False",Toast.LENGTH_LONG).show();
            //Toast.makeText(DatabaseHelper.this,"FAiled",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(DatabaseHelper.this,"passed",Toast.LENGTH_SHORT).show();
        }*/
        //String sql="UPDATE POINTS SET SCORE=SOMEVALUE WHERE ";
        //return true;
        return status;
    }
}

