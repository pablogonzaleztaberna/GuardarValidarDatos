package com.example.guardarvalidardatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Inicializamos elementos de la pantalla login
    EditText editTxt_Nombre, editTxt_Numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Accedemos a ellos a través de su id
        editTxt_Nombre = (EditText) findViewById(R.id.editTxt_Nombre);
        editTxt_Numero = (EditText) findViewById(R.id.editTxt_Numero);

        // Uso de objeto de la clase SharedPreferences para recoger los datos introducidos
        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        editTxt_Nombre.setText(preferences.getString("nombre", ""));
        editTxt_Numero.setText(preferences.getString("numero", ""));

        SharedPreferences preferencesRegistro = getSharedPreferences("campos", Context.MODE_PRIVATE);
        editTxt_Nombre.setText(preferencesRegistro.getString("nombre", ""));
        editTxt_Numero.setText(preferencesRegistro.getString("numero", ""));
    }

    // Método onclick del botón Acceder. Realiza las comprobaciones de los datos que se ingresen
    public void guardarDatos(View view) {
        // Recogemos los datos ingresados creando 2 variables para cada campo
        String inputNombre = editTxt_Nombre.getText().toString();
        String inputNumero = editTxt_Numero.getText().toString();

        // COMPROBACIONES AL HACER CLICK SOBRE ACCEDER

        // Si los 2 campos están vacíos...
        if (inputNombre.isEmpty() && inputNumero.isEmpty()) {
            Toast.makeText(this, "INGRESA DATOS", Toast.LENGTH_SHORT).show();
        }
        // Si el campo Nombre está vacío...
        else if (inputNombre.isEmpty()) {
            Toast.makeText(this, "INGRESA UN NOMBRE", Toast.LENGTH_SHORT).show();
        }
        // Si el campo Número está vacío
        else if (inputNumero.isEmpty()) {
            Toast.makeText(this, "INGRESA UN NÚMERO", Toast.LENGTH_SHORT).show();
        }

        // Si los 2 campos están rellenados se realizan otras comprobaciones
        else {
            // Lo primero será convertir el campo Número a entero.
            int numero = Integer.parseInt(inputNumero);

            // Si el Número es menor o igual que 0...
            if (numero <= 0) {
                Toast.makeText(this, "Tu número debe ser MAYOR QUE 0!", Toast.LENGTH_SHORT).show();
            }
            // Si el número es mayor que 30...
            else if (numero > 30) {
                Toast.makeText(this, "Tu número debe ser MENOR o IGUAL QUE 30!", Toast.LENGTH_SHORT).show();
            }
            // Si todos los datos son correctos...
            else {
                SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
                // Uso de la clase Editor para guardar los datos
                SharedPreferences.Editor editor = preferencias.edit();
                editor.putString("nombre", inputNombre);
                editor.putString("numero", inputNumero);
                // El método commit confirma el guardado de datos
                editor.commit();

                // Hacemos uso del objeto Intent para abrir una nueva pantalla (Inicio)
                Intent inicio = new Intent(this, InicioActivity.class);
                inicio.putExtra("nombre", inputNombre);
                inicio.putExtra("numero", inputNumero);
                startActivity(inicio);
                Toast.makeText(this, "DATOS GUARDADOS", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Método onclick del botón Registrarse que nos dirige a la pantalla de registro
    public void irRegistro(View view) {
        Intent registro = new Intent(this, RegistroActivity.class);
        startActivity(registro);
    }
}