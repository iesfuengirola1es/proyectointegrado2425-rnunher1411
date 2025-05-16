package com.example.trivialdroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InglesActivity extends AppCompatActivity {

    private List<String[]> todasFrases = new ArrayList<String[]>();

    private List<String[]> frasesSeleccionadas = new ArrayList<String[]>();
    private ArrayList<String[]> frasesRecopiladas = new ArrayList<String[]>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingles);

        CheckBox nivelA1 = findViewById(R.id.nivelA1);
        CheckBox nivelA2 = findViewById(R.id.nivelA2);
        CheckBox nivelB1 = findViewById(R.id.nivelB1);
        CheckBox nivelB2 = findViewById(R.id.nivelB2);
        CheckBox nivelC1 = findViewById(R.id.nivelC1);
        CheckBox nivelC2 = findViewById(R.id.nivelC2);

        CheckBox traducirAIngles = findViewById(R.id.traducirAIngles);
        CheckBox traducirAEspañol = findViewById(R.id.traducirAEspañol);

        String[][] todaFrase = new String[60][4];
        Integer id;
        String nivel;
        String fraseIngles;
        String fraseEspanyol;

        try {

            String jsonFileContent = Utiles.leerJson(getApplicationContext(), "TablaIngles.json");
            JSONArray jsonArray = new JSONArray(jsonFileContent);

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                id = jsonObject.getInt("id");
                nivel = jsonObject.getString("nivel");
                fraseIngles = jsonObject.getString("frase ingles");
                fraseEspanyol = jsonObject.getString("frase español");


                todaFrase[i][0] = String.valueOf(id);
                todaFrase[i][1] = nivel;
                todaFrase[i][2] = fraseIngles;
                todaFrase[i][3] = fraseEspanyol;
                todasFrases.add(todaFrase[i]);

            }

        } catch (IOException e) {

            throw new RuntimeException(e);

        } catch (JSONException e) {

            throw new RuntimeException(e);

        }

        Intent intento = new Intent(this, InglesActivity2.class);
        Button botonComenzar = findViewById(R.id.botonComenzarTraducciones);

        botonComenzar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                frasesSeleccionadas = todasFrases;

                if (!nivelC2.isChecked()) {

                    for (int i = 59; i >= 50; i--) {

                        frasesSeleccionadas.remove(i);

                    }

                }

                if (!nivelC1.isChecked()) {

                    for (int i = 49; i >= 40; i--) {

                        frasesSeleccionadas.remove(i);

                    }

                }

                if (!nivelB2.isChecked()) {

                    for (int i = 39; i >= 30; i--) {

                        frasesSeleccionadas.remove(i);

                    }

                }

                if (!nivelB1.isChecked()) {

                    for (int i = 29; i >= 20; i--) {

                        frasesSeleccionadas.remove(i);

                    }

                }

                if (!nivelA2.isChecked()) {

                    for (int i = 19; i >= 10; i--) {

                        frasesSeleccionadas.remove(i);

                    }

                }

                if (!nivelA1.isChecked()) {

                    for (int i = 9; i >= 0; i--) {

                        frasesSeleccionadas.remove(i);

                    }

                }

                for (int i = 0; i < frasesSeleccionadas.size(); i++) {

                    frasesRecopiladas.add(frasesSeleccionadas.get(i));

                }

                if(traducirAEspañol.isChecked() && !traducirAIngles.isChecked() && frasesRecopiladas.size() > 0) {

                    intento.putExtra("frasesSeleccionadas", frasesRecopiladas);
                    startActivity(intento);

                } else if (!traducirAEspañol.isChecked() && traducirAIngles.isChecked() && frasesRecopiladas.size() > 0) {

                    ArrayList<String[]> temp = new ArrayList<String[]>();
                    temp = frasesRecopiladas;
                    String temp1;
                    String temp2;

                    for (int i = 0; i < frasesRecopiladas.size(); i++) {

                        temp1 = temp.get(i)[2];
                        temp2 = temp.get(i)[3];
                        temp.get(i)[2] = temp2;
                        temp.get(i)[3] = temp1;


                    }

                    frasesRecopiladas = temp;

                    intento.putExtra("frasesSeleccionadas", frasesRecopiladas);
                    startActivity(intento);

                }
            }
        });

    }
}