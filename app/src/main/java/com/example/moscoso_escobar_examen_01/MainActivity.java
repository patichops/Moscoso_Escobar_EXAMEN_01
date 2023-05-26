package com.example.moscoso_escobar_examen_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText numero1;
    private EditText numero2;
    private TextView pruebas;
    private Button sumarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero1 = findViewById(R.id.numero1);
        numero2 = findViewById(R.id.numero2);
        sumarButton = findViewById(R.id.buttonSumar);
        pruebas = findViewById(R.id.textViewPruebas);

    }

    public String sumar(String dato1, String dato2){

        short sobrante = 0;
        String resultado = "";
        int valor = 0;

        for (int i = dato1.length() - 1; i >= 0; i--) {
            valor = Integer.parseInt(String.valueOf(dato2.charAt(i))) + Integer.parseInt(String.valueOf(dato1.charAt(i))) + sobrante;

            if (valor >= 10){
                valor = valor - 10;
                sobrante = 1;
                resultado = String.valueOf(valor) + resultado;
            } else {
                sobrante = 0;
                resultado = String.valueOf(valor) + resultado;
            }

        }

        if (sobrante == 1){
            resultado = String.valueOf(sobrante) + resultado;
        }

        return resultado;
    }

    public void onClick_SumarNumero(View view){
        String dato1 = numero1.getText().toString(); //12345
        String dato2 = numero2.getText().toString(); //12

        if (dato2.length() != dato1.length()) {
            if (dato1.length() > dato2.length()){

                for (int i = 0; i < dato1.length() - dato2.length(); i++) {
                    dato2 = "0" + dato2; //0012
                }
                //pruebas.setText(dato1.charAt(0));
                //pruebas.setText(dato1.substring(0,1));
            }

            if (dato2.length() > dato1.length()) {
                for (int i = 0; i < dato2.length() - dato1.length(); i++) {
                    dato1 = "0" + dato1; //0012
                }
            }
        }

        String resp = sumar(dato1, dato2);
        pruebas.setText(resp);
    }
}