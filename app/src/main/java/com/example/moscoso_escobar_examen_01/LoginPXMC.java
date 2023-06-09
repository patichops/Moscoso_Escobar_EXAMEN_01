package com.example.moscoso_escobar_examen_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.moscoso_escobar_examen_01.UsuarioPXMC;

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

        values = new ContentValues();
        values.put("usuario", "usuario2");
        values.put("clave", "1234");

        sql.insert("PRUEBADB","usuarios", values);

        usuario = findViewById(R.id.editTextUsuarioPXMC);
        contraseña = findViewById(R.id.editTextContraseñaPXMC);

    }

    public void Onclick_Aceptar(View v){

        if (usuario.getText().toString().isEmpty() || contraseña.getText().toString().isEmpty()) {
            Toast.makeText(this, "LLene todos los campos", Toast.LENGTH_SHORT).show();
        } else {
            String user = usuario.getText().toString();
            String passwd = contraseña.getText().toString();

            String SELECT = "SELECT usuario, clave FROM USUARIOS " +
                            "WHERE usuario = " + user +
                            " AND clave = " + passwd;

            Cursor cursor = sql.rawQuery(SELECT, null);

            if (cursor.moveToFirst()){

            } else {
                Toast.makeText(this, "LLene todos los campos", Toast.LENGTH_SHORT).show();
            }

        }


    }
}