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
    TextView txtV_1, txtV_2;
    Button btnParImpar, btnPar, btnImpar, btnInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numeros);

        // Accedemos a esos elementos por su id
        txtV_1 = (TextView) findViewById(R.id.txtV_1);
        txtV_2 = (TextView) findViewById(R.id.txtV_2);
        btnParImpar = (Button) findViewById(R.id.btnParImpar);
        btnPar = (Button) findViewById(R.id.btnPar);
        btnImpar = (Button) findViewById(R.id.btnImpar);
        btnInicio = (Button) findViewById(R.id.btnInicio);

        // Método click para el botón PAR IMPAR
        btnParImpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Click sobre Botón PAR IMPAR", Toast.LENGTH_SHORT).show();
                txtV_1.setText("UNO");
                txtV_2.setText("DOS");
            }
        });

        // Método click para el botón PAR
        btnPar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Click sobre Botón PAR", Toast.LENGTH_SHORT).show();
                txtV_1.setText("DOS");
                txtV_2.setText("CUATRO");
            }
        });

        // Método click para el botón IMPAR
        btnImpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Click sobre Botón IMPAR", Toast.LENGTH_SHORT).show();
                txtV_1.setText("UNO");
                txtV_2.setText("TRES");
            }
        });
    }

    public void irInicio(View view) {
        Intent inicio = new Intent(this, InicioActivity.class);
        startActivity(inicio);
    }
}