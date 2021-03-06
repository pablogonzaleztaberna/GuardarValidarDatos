package com.example.guardarvalidardatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NumerosActivity extends AppCompatActivity {

    // Inicializamos los elementos introducidos en el activity_numeros.xml
    TextView txtV_Numero1, txtV_Numero2;
    Button btnParImpar, btnPar, btnImpar, btnInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numeros);

        // Accedemos a esos elementos por su id
        txtV_Numero1 = (TextView) findViewById(R.id.txtV_Numero1);
        txtV_Numero2 = (TextView) findViewById(R.id.txtV_Numero2);
        btnParImpar = (Button) findViewById(R.id.btnParImpar);
        btnPar = (Button) findViewById(R.id.btnPar);
        btnImpar = (Button) findViewById(R.id.btnImpar);
        btnInicio = (Button) findViewById(R.id.btnInicio);

        // Método click para el botón PAR IMPAR
        btnParImpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Click sobre Botón PAR IMPAR", Toast.LENGTH_SHORT).show();
                txtV_Numero1.setText("UNO");
                txtV_Numero2.setText("DOS");
            }
        });

        // Método click para el botón PAR
        btnPar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Click sobre Botón PAR", Toast.LENGTH_SHORT).show();
                txtV_Numero1.setText("DOS");
                txtV_Numero2.setText("CUATRO");
            }
        });

        // Método click para el botón IMPAR
        btnImpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Click sobre Botón IMPAR", Toast.LENGTH_SHORT).show();
                txtV_Numero1.setText("UNO");
                txtV_Numero2.setText("TRES");
            }
        });
    }

    // Método onclick del botón Volver a Inicio que nos dirige a la pantalla de inicio
    public void irInicio(View view) {
        Intent inicio = new Intent(this, InicioActivity.class);
        startActivity(inicio);
    }
}