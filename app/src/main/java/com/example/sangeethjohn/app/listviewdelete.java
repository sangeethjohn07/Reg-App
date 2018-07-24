package com.example.sangeethjohn.app;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class listviewdelete extends AppCompatActivity {

    ArrayList<String> al=new ArrayList<String>();
    ArrayAdapter<String> ad;
    SQLiteDatabase db;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listviewdelete);
        db = openOrCreateDatabase("mytable", 0, null);
        //db.execSQL("create if not exists mytable(name varchar(30),id int)");
        Cursor cu = db.rawQuery("select * from mytable", null);
        cu.moveToFirst();
        try {
            do {
                String s1 = cu.getString(cu.getColumnIndex("name"));
                al.add(s1);

            } while (cu.moveToNext());
            ad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, al);
            ListView l = findViewById(R.id.listd);
            l.setAdapter(ad);
            registerForContextMenu(l);
        } catch (Exception e)
        {

        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.options,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int pos=info.position;
        if(item.getItemId()==R.id.del) {
            String ss=al.get(pos);

            al.remove(pos);
            ad.notifyDataSetChanged();

            db.delete("mytable","name=?",new String[]{ss});
        }
        return super.onContextItemSelected(item);
    }
}
