package com.programacionandroid.practica_sqlite.entidades;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.programacionandroid.practica_sqlite.R;
import com.programacionandroid.practica_sqlite.db.dbContactos;

public class NewActivity extends AppCompatActivity {

    EditText txtNombre, txtTelefono, txtCorreo;
    Button btnGuarda;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtNombre = findViewById(R.id.txtNombre);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtCorreo = findViewById(R.id.txtCorreo);
        btnGuarda = findViewById(R.id.btnEnviar);

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbContactos dbContactos = new dbContactos(NewActivity.this);
                long id = dbContactos.insertarContacto(txtNombre.getText().toString(), txtTelefono.getText().toString(),txtCorreo.getText().toString());
                if(id > 0){
                    Toast.makeText(NewActivity.this, "Registro Guardado", Toast.LENGTH_LONG).show();
                    limpiar();
                }else{
                    Toast.makeText(NewActivity.this, "Erro al guardar el registro", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void limpiar() {
        txtNombre.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
    }
}
