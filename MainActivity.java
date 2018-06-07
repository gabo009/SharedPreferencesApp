package com.example.nacho.sharedpreferencesapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText et_rut, et_nombre, et_email;
    private Button btn_leer, btn_guardar, btn_borrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_rut = (EditText) findViewById(R.id.et_rut);
        et_nombre = (EditText) findViewById(R.id.et_nombre);
        et_email = (EditText) findViewById(R.id.et_email);
        btn_leer = (Button) findViewById(R.id.btn_leer);
        btn_guardar = (Button) findViewById(R.id.btn_guardar);
        btn_borrar = (Button) findViewById(R.id.btn_borrar);

        //onclick boton leer
        btn_leer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leerSharedPreference();
            }
        });
        //onclick boton guardar
        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarSharedPreference();
            }
        });
        //onclic boton borrar
        btn_borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                borrarSharedPreferences();
            }
        });
    }

    private void leerSharedPreference (){
        //referencia el archivo Shared preferences si no existe lo crea
        SharedPreferences preferencias = getSharedPreferences("datosPersonales", Context.MODE_PRIVATE);

        //lee en el shared preferences (etiqueta que queremos leer, valor que devuelve si no hay nada en este caso los dejaria en blanco )
        et_rut.setText(preferencias.getString("rut", ""));
        et_nombre.setText(preferencias.getString("nombre", ""));
        et_email.setText(preferencias.getString("email", ""));
    }

    private  void guardarSharedPreference (){
        //referencia el archivo Shared preferences si no existe lo crea
        SharedPreferences preferencias = getSharedPreferences("datosPersonales", Context.MODE_PRIVATE);

        //crear editor para modifcar el Shared preferencias llamado arriba
        SharedPreferences.Editor editarPreferencias = preferencias.edit();
        //modifica los datos en el Sahared prefences, si no existe lo crea (etiqueta en la que guardaremos, datos a guardar)
        editarPreferencias.putString("rut", et_rut.getText().toString());
        editarPreferencias.putString("nombre", et_nombre.getText().toString());
        editarPreferencias.putString("email", et_email.getText().toString());
        //guarda
        editarPreferencias.commit();
    }

    private void borrarSharedPreferences(){
        //referencia el archivo Shared preferences si no existe lo crea
        SharedPreferences preferencias = getSharedPreferences("datosPersonales", Context.MODE_PRIVATE);

        //crear editor para modifcar el Shared preferencias llamado arriba
        SharedPreferences.Editor editarPreferencias = preferencias.edit();
        //borra las etiquetas
        editarPreferencias.remove("rut");
        editarPreferencias.remove("nombre");
        editarPreferencias.remove("email");
        //guarda
        editarPreferencias.commit();
    }
}

