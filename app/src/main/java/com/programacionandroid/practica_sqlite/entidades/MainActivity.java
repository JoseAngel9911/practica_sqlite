package com.programacionandroid.practica_sqlite.entidades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.programacionandroid.practica_sqlite.R;
import com.programacionandroid.practica_sqlite.db.DBHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    public boolean onOptionItemSelected(MenuItem item){

        switch(item.getItemId()){
            case R.id.menuNuevo:
                nuevoRegistro();
                return true;

            case R.id.crearBase:
                crearBase();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void crearBase() {
        DBHelper dbHelper = new DBHelper(MainActivity.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        
        if(db != null){
            Toast.makeText(MainActivity.this, "Base de datos creado", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(MainActivity.this, "Error al crear base de datos", Toast.LENGTH_LONG).show();
        }
        
    }

    private void nuevoRegistro() {
        Intent intent = new Intent(this, NewActivity.class);
        startActivity(intent);
    }

}