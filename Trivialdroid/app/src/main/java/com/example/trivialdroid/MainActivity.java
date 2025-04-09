package com.example.trivialdroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import java.lang.String;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private String[] asignaturas = {"ingles","matematicas"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = findViewById(R.id.asignaturaSpinner);
        ArrayAdapter<String>adaptador1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, asignaturas);
        spinner1.setAdapter(adaptador1);


        Button boton = findViewById(R.id.botonElegirAsignatura);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String asignaturaSeleccionada = spinner1.getSelectedItem().toString();

                if (asignaturaSeleccionada == "matematicas") {

                    startActivity(new Intent(getApplicationContext(), MatematicasActivity.class));

                }

                if (asignaturaSeleccionada == "ingles") {

                    startActivity(new Intent(getApplicationContext(), InglesActivity.class));

                }

            }
        });

    }
}