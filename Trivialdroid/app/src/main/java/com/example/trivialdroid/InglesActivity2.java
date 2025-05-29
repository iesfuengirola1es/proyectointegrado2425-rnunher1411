package com.example.trivialdroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InglesActivity2 extends AppCompatActivity {

    int segundos=0, minutos=0, acierto=0, fallo=0, numFrase=0;

    String fraseAComprobar = "";

    Boolean isOn = false;

    ExecutorService cronometro = Executors.newSingleThreadExecutor();;

    TextView textoCronometro;

    Handler h = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingles2);

        //hola
        ArrayList<String[]> valoresFrasesSeleccionadas = (ArrayList<String[]>)getIntent().getSerializableExtra("frasesSeleccionadas");

        minutos = Integer.valueOf(1);
        segundos = 0;

        textoCronometro = (TextView) findViewById(R.id.textoCronometro2);
        textoCronometro.setText(minutos + " : 00");
        Intent intento = new Intent(this, InglesActivity3.class);

        cronometro.execute(new Runnable() {

            @Override
            public void run() {

                while (true) {

                    if (true) {

                        try {

                            Thread.sleep(1000);

                        } catch (InterruptedException e) {

                            e.printStackTrace();

                        }

                        if (segundos == 0 && minutos != 0) {

                            minutos--;
                            segundos = 60;

                        }

                        if (segundos == 0 & minutos == 0) {

                            intento.putExtra("aciertos", acierto);
                            intento.putExtra("fallos", fallo);

                            startActivity(intento);
                            break;

                        } else {

                            segundos--;

                        }

                        h.post(new Runnable() {
                            @Override
                            public void run() {

                                String min="", s="";

                                min = ""+minutos;

                                if (segundos < 10) {

                                    s = "0" + segundos;

                                } else {

                                    s = "" + segundos;

                                }

                                textoCronometro.setText(min + " : " + s);

                            }
                        });

                    }

                }

            }
        });

        TextView aciertos = findViewById(R.id.aciertos);
        TextView fallos = findViewById(R.id.fallos);

        aciertos.setText(String.valueOf(acierto));
        fallos.setText(String.valueOf(fallo));

        TextView fraseATraducir = findViewById(R.id.fraseATraducir);

        fraseATraducir.setText(valoresFrasesSeleccionadas.get(numFrase)[2]);

        TextView fraseTraducida = findViewById(R.id.fraseTraducida);
        EditText traduciendoFrase = findViewById(R.id.traduciendoFrase);

        Button comprobarTraduccion = findViewById(R.id.comprobarTraduccion);
        Button siguienteFrase = findViewById(R.id.siguienteFrase);

        comprobarTraduccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isOn) {

                    fraseAComprobar = traduciendoFrase.getText().toString();
                    fraseTraducida.setText(valoresFrasesSeleccionadas.get(numFrase)[3]);

                    if (fraseAComprobar.equals(fraseTraducida.getText().toString())) {

                        acierto++;
                        aciertos.setText(String.valueOf(acierto));

                    } else {

                        fallo++;
                        fallos.setText(String.valueOf(fallo));

                    }

                    isOn = true;

                }
            }
        });

        siguienteFrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isOn) {

                    numFrase++;

                    if (numFrase < valoresFrasesSeleccionadas.size()) {

                        fraseATraducir.setText(valoresFrasesSeleccionadas.get(numFrase)[2]);
                        traduciendoFrase.setText("");
                        fraseTraducida.setText("");
                        isOn = false;

                    } else {

                        intento.putExtra("aciertos", acierto);
                        intento.putExtra("fallos", fallo);

                        startActivity(intento);

                    }

                }

            }
        });

    }
}