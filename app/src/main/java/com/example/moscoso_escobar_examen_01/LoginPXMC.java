package com.example.moscoso_escobar_examen_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.database.sqlite.SQLiteDatabaseKt;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.moscoso_escobar_examen_01.UsuarioPXMC;

public class LoginPXMC extends AppCompatActivity {

    private SQLiteDatabase sql;
    private SQLiteOpenHelper sqLiteOpenHelper;
    private EditText usuario;
    private EditText contraseña;
    private View layoutLogin;
    private Button aceptar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        layoutLogin = findViewById(R.id.layoutLogin);

        sqLiteOpenHelper = new SQLiteOpenHelper(this,"PRUEBADB", null,1) {
            @Override
            public void onCreate(SQLiteDatabase sqLiteDatabase) {
                final String ELIMINAR="DROP TABLE IF EXISTS USUARIOS";
                final String USUARIOS="CREATE TABLE USUARIOS(nombre TEXT, clave TEXT)";
                sql.execSQL(ELIMINAR);
                sql.execSQL(USUARIOS);
            }

            @Override
            public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

            }
        };


        sql = sqLiteOpenHelper.getWritableDatabase();

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
        aceptar = findViewById(R.id.buttonAceptarPXMC);


        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Onclick_Aceptar(view);
            }
        });
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
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("usuario", user);
                sql.close();
                startActivity(intent);
            } else {
                Toast.makeText(this, "Usuario no existente, compruebe su contraseña o nombre de usuario", Toast.LENGTH_SHORT).show();
            }

        }


    }
}