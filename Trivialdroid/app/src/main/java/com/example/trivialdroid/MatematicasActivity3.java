package com.example.trivialdroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MatematicasActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matematicas3);

        Bundle datos = getIntent().getExtras();
        int aciertosFinales = datos.getInt("aciertos");
        int fallosFinales = datos.getInt("fallos");

        TextView aciertosResultado = findViewById(R.id.aciertosFinales);
        TextView fallosResultado = findViewById(R.id.fallosFinales);

        aciertosResultado.setText(String.valueOf(aciertosFinales));
        fallosResultado.setText(String.valueOf(fallosFinales));

        Button reiniciarJuego = findViewById(R.id.botonNuevoJuego);
        Button elegirAsignatura = findViewById(R.id.botonVolverElegirAsignatura);

        Intent intentoReiniciarJuegp = new Intent(this, MatematicasActivity.class);
        Intent intentoElegirAsignatura = new Intent(this, MainActivity.class);

        reiniciarJuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(intentoReiniciarJuegp);

            }
        });

        elegirAsignatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(intentoElegirAsignatura);

            }
        });

    }
}