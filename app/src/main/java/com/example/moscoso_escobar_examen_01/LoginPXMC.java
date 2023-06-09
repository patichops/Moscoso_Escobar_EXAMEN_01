package com.example.moscoso_escobar_examen_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginPXMC extends AppCompatActivity {

    private SQLiteDatabase sql;
    private EditText usuario;
    private EditText contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        

        final String USUARIOS="CREATE TABLE USUARIOS(nombre TEXT, clave TEXT)";

        sql.execSQL(USUARIOS);

        ContentValues values = new ContentValues();
        values.put("usuario", "usuario1");
        values.put("clave", "1234");

        sql.insert("PRUEBADB","usuarios", values);

        usuario = findViewById(R.id.editTextUsuarioPXMC);
        contraseña = findViewById(R.id.editTextContraseñaPXMC);



    }

    public void Onclick_Aceptar(View v){




        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}