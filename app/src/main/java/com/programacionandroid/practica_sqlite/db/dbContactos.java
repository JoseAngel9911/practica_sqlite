package com.programacionandroid.practica_sqlite.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class dbContactos  extends DBHelper{

    Context context;

    public dbContactos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarContacto(String nombreP, String telefonoP, String correoP){
        long id = 0;

        try {
            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombreP);
            values.put("telefono", telefonoP);
            values.put("correo", correoP);

            id = db.insert(TABLA_CONTACTOS, null, values);

        }catch (Exception e){
            e.toString();
        }
        return id;
    }

}
