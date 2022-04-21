package com.example.guardarvalidardatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    // Inicializamos elementos que validaremos de la pantalla de registro
    EditText editTxt_NombreRegistro, editTxt_NumeroRegistro;
    RadioGroup radioTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        // Accedemos a ellos a través de su id
        editTxt_NombreRegistro = (EditText) findViewById(R.id.editTxt_NombreRegistro);
        editTxt_NumeroRegistro = (EditText) findViewById(R.id.editTxt_NumeroRegistro);
        radioTipo = (RadioGroup) findViewById(R.id.radioTipo);
    }

    // Método onclick del botón Guardar. Realiza las comprobaciones de los datos rellenados
    public void guardarRegistro(View view) {
        // Recogemos los datos ingresados creando variables para cada campo
        String inputNombreRegistro = editTxt_NombreRegistro.getText().toString();
        String inputNumeroRegistro = editTxt_NumeroRegistro.getText().toString();
        int radioTipoSelect = radioTipo.getCheckedRadioButtonId();

        // COMPROBACIONES AL HACER CLICK SOBRE GUARDAR

        // Si todos los campos están vacíos...
        if (inputNombreRegistro.isEmpty() && inputNumeroRegistro.isEmpty() && radioTipoSelect == -1) {
            Toast.makeText(this, "RELLENA DATOS DE REGISTRO", Toast.LENGTH_SHORT).show();
        }
        // Si los campos Nombre y Número están vacíos...
        else if (inputNombreRegistro.isEmpty() && inputNumeroRegistro.isEmpty()) {
            Toast.makeText(this, "RELLENA CAMPO NOMBRE Y NÚMERO", Toast.LENGTH_SHORT).show();
        }
        // Si los campos Nombre y Tipo están vacíos...
        else if (inputNombreRegistro.isEmpty()  && radioTipoSelect == -1) {
            Toast.makeText(this, "RELLENA CAMPO NOMBRE Y TIPO", Toast.LENGTH_SHORT).show();
        }
        // Si los campos Número y Tipo están vacíos...
        else if (inputNumeroRegistro.isEmpty()  && radioTipoSelect == -1) {
            Toast.makeText(this, "RELLENA CAMPO NÚMERO Y TIPO", Toast.LENGTH_SHORT).show();
        }
        // Si el campo Nombre está vacío...
        else if (inputNombreRegistro.isEmpty()) {
            Toast.makeText(this, "RELLENA CAMPO NOMBRE", Toast.LENGTH_SHORT).show();
        }
        // Si el campo Número está vacío...
        else if (inputNumeroRegistro.isEmpty()) {
            Toast.makeText(this, "RELLENA CAMPO NÚMERO", Toast.LENGTH_SHORT).show();
        }
        // Si no hay seleccionado ningún Tipo...
        else if (radioTipoSelect == -1) {
            Toast.makeText(this, "SELECCIONA TIPO", Toast.LENGTH_SHORT).show();
        }

        // Si todos los campos están rellenados se realizan otras comprobaciones
        else {
            // Lo primero será convertir el campo Número a entero.
            int numero = Integer.parseInt(inputNumeroRegistro);

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
                SharedPreferences preferencias = getSharedPreferences("campos", Context.MODE_PRIVATE);
                // Uso de la clase Editor para guardar los datos
                SharedPreferences.Editor editor = preferencias.edit();
                editor.putString("nombre", inputNombreRegistro);
                editor.putString("numero", inputNumeroRegistro);
                // El método commit confirma el guardado de datos
                editor.commit();

                // Hacemos uso del objeto Intent para redirigirnos a la pantalla login
                Intent login = new Intent(this, MainActivity.class);
                // Donde los campos Nombre y Número se añaden automáticamente para acceder
                login.putExtra("nombre", inputNombreRegistro);
                login.putExtra("numero", inputNumeroRegistro);
                startActivity(login);
                Toast.makeText(this, "DATOS AÑADIDOS", Toast.LENGTH_SHORT).show();
            }
        }
    }
}