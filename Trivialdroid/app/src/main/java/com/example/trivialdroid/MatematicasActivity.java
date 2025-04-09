package com.example.trivialdroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MatematicasActivity extends AppCompatActivity {

    private Spinner spinnerCronometro;
    private Integer[] tiempo = {1, 2, 3, 4, 5};
    private Spinner spinnerOperacion;
    private List<String> nombreOperaciones = new ArrayList<String>();
    private List<String> simbolos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matematicas);

        spinnerCronometro = findViewById(R.id.spinnerCronometro);
        ArrayAdapter<Integer> adaptadorCronometro = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tiempo);
        spinnerCronometro.setAdapter(adaptadorCronometro);

        spinnerOperacion = findViewById(R.id.spinnerOperacion);

        try {

            String jsonFileContent = Utiles.leerJson(getApplicationContext(), "TablaMatematicas.json");
            JSONArray jsonArray = new JSONArray(jsonFileContent);

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Integer id = jsonObject.getInt("id");
                String name = jsonObject.getString("nombre");
                String token = jsonObject.getString("simbolo");

                nombreOperaciones.add(name);
                simbolos.add(token);

            }

            ArrayAdapter<String> adaptadorOperaciones = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, nombreOperaciones);
            spinnerOperacion.setAdapter(adaptadorOperaciones);

        } catch (IOException e) {

            throw new RuntimeException(e);

        } catch (JSONException e) {

            throw new RuntimeException(e);

        }

        Intent intento = new Intent(this, MatematicasActivity2.class);
        Button botonComenzar = findViewById(R.id.botonComenzar);

        botonComenzar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String operacionAsignada = spinnerOperacion.getSelectedItem().toString();
                String tiempoAsignado = spinnerCronometro.getSelectedItem().toString();
                String simboloAsignado = "";

                for (int i = 0; i < simbolos.size(); i++) {

                    simboloAsignado = simbolos.get(i);

                    if (spinnerOperacion.getLastVisiblePosition() == i) {

                        i = simbolos.size() + 1;

                    }

                }

                intento.putExtra("operacion", simboloAsignado);
                intento.putExtra("cronometro", tiempoAsignado);

                startActivity(intento);

            }
        });

    }
}