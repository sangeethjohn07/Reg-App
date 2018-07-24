package com.example.sangeethjohn.app;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class insert extends AppCompatActivity {
    EditText n1,i1;
    SQLiteDatabase db;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
    }


    public void tableins(View view) {
        n1=findViewById(R.id.nameins);
        i1=findViewById(R.id.idins);
        String s1=n1.getText().toString();
        int s2=Integer.parseInt(i1.getText().toString());
        db=openOrCreateDatabase("mytable",0,null);
        db.execSQL("create table if not exists mytable(name varchar(30),id int)");
        ContentValues c=new ContentValues();
        c.put("name",s1);
        c.put("id",s2);
        db.insert("mytable",null,c);
        Intent i3=new Intent(this,app1.class);
        startActivity(i3);
    }
}
