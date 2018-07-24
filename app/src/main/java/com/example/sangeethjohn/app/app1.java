package com.example.sangeethjohn.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class app1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app1);
    }

    public void ins(View view) {
        Intent i=new Intent(this,insert.class);
        startActivity(i);
    }

    public void goselect(View view) {
        Intent i1=new Intent(this,select.class);
        startActivity(i1);
    }

    public void godelete(View view) {
        Intent i2=new Intent(this,listviewdelete.class);
        startActivity(i2);
    }
}
