package com.example.guardarvalidardatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InicioActivity extends AppCompatActivity {

    // Inicializamos elementos de la pantalla inicio
    TextView txtV_Nombre, txtV_Numero;
    Button btnNumeros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        // Accedemos a esos elementos por su id
        txtV_Nombre = (TextView) findViewById(R.id.txtV_Nombre);
        txtV_Numero = (TextView) findViewById(R.id.txtV_Numero);
        btnNumeros = (Button) findViewById(R.id.btnNumeros);

        // Recogemos los datos introducidos por el usuario...
        String nombre = getIntent().getStringExtra("nombre");
        // ... y los añadimos a los TextView
        txtV_Nombre.setText("NOMBRE: " + nombre);
        String numero = getIntent().getStringExtra("numero");
        txtV_Numero.setText("NÚMERO: " + numero);

        // Uso de objeto de la clase SharedPreferences para recoger los datos introducidos
        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        txtV_Nombre.setText(preferences.getString("nombre", ""));
        txtV_Numero.setText(preferences.getString("numero", ""));
    }

    // Método de botón Logout para redirigirnos a la pantalla de login
    public void Logout(View view) {
        Intent login = new Intent(this, MainActivity.class);
        startActivity(login);
    }

    public void irNumeros(View view) {
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        // Uso de la clase Editor para guardar los datos
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("nombre", txtV_Nombre.getText().toString());
        editor.putString("numero", txtV_Numero.getText().toString());
        // El método commit confirma el guardado de datos
        editor.commit();

        // Hacemos uso del objeto Intent para abrir una nueva pantalla (Numeros)
        Intent numeros = new Intent(this, NumerosActivity.class);
        startActivity(numeros);
    }
}