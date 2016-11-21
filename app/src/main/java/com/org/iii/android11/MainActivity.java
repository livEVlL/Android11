package com.org.iii.android11;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private MyDBhelper dbHelper;
    private SQLiteDatabase db;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.tv);

        dbHelper = new MyDBhelper(this, "iii", null, 1);
        db = dbHelper.getReadableDatabase();

    }

    public void add(View v) {
        // INSERT INTO cust (cname,birthday,tel) VALUES ('Brad','1999-09-08','123');
        ContentValues data = new ContentValues();
        data.put("cname", "Andy");
        data.put("birthday", "2003-04-24");
        data.put("tel", "9453");
        db.insert("cust",null, data);
        select(null);
    }

    public void delete(View v){
        //DELETE FROM cust WHERE id = 3 AND cname = 'Brad'
        db.delete("cust","id = ? AND cname = ?",new String[]{"3","AB"});
        select(null);
    }

    public void update(View v){
        ContentValues data = new ContentValues();
        data.put("cname", "XYZ");
        data.put("birthday", "2002-08-08");
        data.put("tel", "321");
        db.update("cust",data,"id = ? ",new String[]{"4"});
        select(null);
    }

    public void select(View v){
        textView.setText("");
        // SELECT * FROM cust
        // db.execSQL("SELECT * FROM cust");
        Cursor cursor = db.query("cust",null,null,null,null,null,"cname DESC");

        while (cursor.moveToNext()){
            String id = cursor.getString(cursor.getColumnIndex("id"));
            String cname = cursor.getString(cursor.getColumnIndex("cname"));
            String birthday = cursor.getString(cursor.getColumnIndex("birthday"));
            String tel = cursor.getString(cursor.getColumnIndex("tel"));
            textView.append(id +":"+ cname + ":" + birthday + ":" + tel + "\n");
        }

    }

}
