package com.example.mlab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnAdd,btnRead,btnClear,btnSort;
    EditText nameText,seasonText,periodText,avarangeText;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnRead = (Button) findViewById(R.id.btnRead);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnSort = (Button) findViewById(R.id.btnSort);


        SQLiteDatabase database = dbHelper.getWritableDatabase();
/*
        ContentValues contentValues = new ContentValues();

        contentValues.put(DBHelper.KEY_NAME,"test");
        contentValues.put(DBHelper.KEY_MARK1,60);
        contentValues.put(DBHelper.KEY_MARK2,60);

        database.insert(DBHelper.TABLE_MARKS, null, contentValues);
        dbHelper.close();*/

        dbHelper = new DBHelper(this);
    }
/*
    @SuppressLint("NonConstantResourceId")
    public void onClick(View v){
        String name = nameText.getText().toString();
        String mark1 = firstmarkText.getText().toString();
        String mark2 = secondmarkText.getText().toString();

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        switch (v.getId()){
            case R.id.btnAdd:
                contentValues.put(DBHelper.KEY_NAME,name);
                contentValues.put(DBHelper.KEY_MARK1,mark1);
                contentValues.put(DBHelper.KEY_MARK2,mark2);

                database.insert(DBHelper.TABLE_MARKS, null, contentValues);
                break;

            case R.id.btnRead:
                Cursor cursor = database.query(DBHelper.TABLE_MARKS, null, null, null, null, null, null);

                if (cursor.moveToFirst()){
                    int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
                    int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
                    int mark1Index = cursor.getColumnIndex(DBHelper.KEY_MARK1);
                    int mark2Index = cursor.getColumnIndex(DBHelper.KEY_MARK2);
                        do {
                            Log.d("mLog", "ID = " + cursor.getInt(idIndex) + ", name = " + cursor.getString(nameIndex) + ", mark1 = "+ cursor.getString(mark1Index) + ", mark2 = "+ cursor.getString(mark2Index));
                        } while (cursor.moveToNext());
                } else
                    Log.d("mLog", "0 rows");

                cursor.close();
                break;
            case R.id.btnClear:
                database.delete(DBHelper.TABLE_MARKS,null, null);

                break;
            case R.id.btnSort:

                break;
        }
        dbHelper.close();
    }*/

    public void onAddClick(View v){
        String name = nameText.getText().toString();
        String season = seasonText.getText().toString();
        String period = periodText.getText().toString();
        String avarange = avarangeText.getText().toString();

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(DBHelper.KEY_NAME,name);
        contentValues.put(DBHelper.KEY_SEASON,season);
        contentValues.put(DBHelper.KEY_PERIOD,period);
        contentValues.put(DBHelper.KEY_AVARANGE,avarange);

        database.insert(DBHelper.TABLE_FARM, null, contentValues);
        dbHelper.close();
    }

    public void onReadClick(View v){
        String name = nameText.getText().toString();
        String season = seasonText.getText().toString();
        String period = periodText.getText().toString();
        String avarange = avarangeText.getText().toString();

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        Cursor cursor = database.query(DBHelper.TABLE_FARM, null, null, null, null, null, null);

        if (cursor.moveToFirst()){
            int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
            int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
            int seasonIndex = cursor.getColumnIndex(DBHelper.KEY_SEASON);
            int periodIndex = cursor.getColumnIndex(DBHelper.KEY_PERIOD);
            int avarangeIndex = cursor.getColumnIndex(DBHelper.KEY_AVARANGE);
            do {
                Log.d("mLog", "ID = " + cursor.getInt(idIndex) + ", name = " + cursor.getString(nameIndex) + ", season = "+ cursor.getString(seasonIndex)
                        + ", period = "+ cursor.getString(periodIndex) + ", avarange = "+ cursor.getString(avarangeIndex));
            } while (cursor.moveToNext());
        } else
            Log.d("mLog", "0 rows");

        cursor.close();
        dbHelper.close();
    }

}