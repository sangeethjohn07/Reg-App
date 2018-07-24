package com.example.sangeethjohn.app;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class select extends AppCompatActivity {

    EditText e;
    TextView t;
    SQLiteDatabase db;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
    }

    public void goback(View view) {
        Intent i=new Intent(this,app1.class);
        startActivity(i);
    }

    public void gofind(View view) {
        e=findViewById(R.id.selid);
        t=findViewById(R.id.textView);
        String s=e.getText().toString();
        db=openOrCreateDatabase("mytable",0,null);
        db.execSQL("create table if not exists mytable(name varchar(30),id int)");
        try {
            Cursor cur = db.rawQuery("select name from mytable where id=?", new String[]{s});
            cur.moveToFirst();
            String abc = cur.getString(cur.getColumnIndex("name"));
            t.setText(abc);
        }
        catch (Exception e)
        {
            t.setText("not found");
        }
    }
}
