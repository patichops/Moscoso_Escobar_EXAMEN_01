package com.example.moscoso_escobar_examen_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText numero1;
    private EditText numero2;
    private Button sumarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TI2023_CLAVE_00

        numero1 = findViewById(R.id.numero1);
        numero2 = findViewById(R.id.numero2);
        sumarButton = findViewById(R.id.buttonSumar);


        short acarreo = 0;



    }

    public String SumarNumero(){
        short acarreo = 0;
        String dato1 = numero1.getText().toString();
        String dato2 = numero2.getText().toString();
        String resultado = numero2.getText().toString();

        if (dato1.length() > dato2.length()){
            
        }

        return resultado;
    }
}