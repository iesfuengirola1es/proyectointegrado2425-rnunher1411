package com.example.trivialdroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MatematicasActivity2 extends AppCompatActivity {

    int segundos=0, minutos=0, resultadoInt=0, numero1=0, numero2=0, acierto=0, fallo=0, a=0, b=0, botonCorrecto=0;

    double resultado=0, numboton1=0,numboton2=0,numboton3=0;

    String valorOperacionElegido = "", letraElegida = "", numero1Final = "", numero2Final = "", resultadoFinal = "";

    String[] variado = {"+","-","*","/"};

    String[] algebra = {"a", "b"};

    ExecutorService cronometro = Executors.newSingleThreadExecutor();;

    TextView textoCronometro;

    TextView textoResultado;

    Boolean isOn = false;

    Handler h = new Handler();

    DecimalFormat form = new DecimalFormat("0.00");
    DecimalFormat formNoDecimal = new DecimalFormat("0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matematicas2);

        Bundle datos = getIntent().getExtras();
        String valorOperacion = datos.getString("operacion");
        String valorCronometro = datos.getString("cronometro");

        minutos = Integer.valueOf(valorCronometro);
        segundos = 0;

        textoCronometro = (TextView) findViewById(R.id.textoCronometro2);
        textoCronometro.setText(minutos + " : 00");
        Intent intento = new Intent(this, MatematicasActivity3.class);

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

        TextView textoOperacion = findViewById(R.id.textoOperacion2);

        if(valorOperacion.equals("+,-,*,/") || valorOperacion.equals("a,b")) {

            valorOperacionElegido = variado[(int) Math.floor(Math.random() * variado.length)];
            textoOperacion.setText(valorOperacionElegido);

        } else {

            textoOperacion.setText(valorOperacion);

        }

        TextView textoNumero1 = findViewById(R.id.numero1);
        TextView textoNumero2 = findViewById(R.id.numero2);

        numero1 = Integer.valueOf(textoNumero1.getText().toString());
        numero2 = Integer.valueOf(textoNumero2.getText().toString());

        numero1 = (int) ((Math.random() * 10) + 1);
        numero2 = (int) ((Math.random() * 10) + 1);

        switch (valorOperacion) {

            case "+":
                resultado = Double.valueOf(formNoDecimal.format(numero1 + numero2));
                break;

            case "-":
                resultado = Double.valueOf(formNoDecimal.format(numero1 - numero2));
                break;

            case "*":
                resultado = Double.valueOf(formNoDecimal.format(numero1 * numero2));
                break;

            case "/":
                resultado = Double.valueOf(form.format((double) numero1 / numero2));
                break;

            case "+,-,*,/":

                switch (valorOperacionElegido) {

                    case "+":
                        resultado = Double.valueOf(formNoDecimal.format(numero1 + numero2));
                        break;

                    case "-":
                        resultado = Double.valueOf(formNoDecimal.format(numero1 - numero2));
                        break;

                    case "*":
                        resultado = Double.valueOf(formNoDecimal.format(numero1 * numero2));
                        break;

                    case "/":
                        resultado = Double.valueOf(form.format((double) numero1 / numero2));
                        break;

                }
                break;

            case "a,b":

                letraElegida = algebra[(int) Math.floor(Math.random() * algebra.length)];

                switch (letraElegida) {

                    case "a":

                        switch (valorOperacionElegido) {

                            case "+":
                                resultado = Double.valueOf(formNoDecimal.format(numero1 + numero2));
                                numero1Final = "a";
                                numero2Final = String.valueOf(numero2);
                                break;

                            case "-":
                                resultado = Double.valueOf(formNoDecimal.format(numero1 - numero2));
                                numero1Final = "a";
                                numero2Final = String.valueOf(numero2);
                                break;

                            case "*":
                                resultado = Double.valueOf(formNoDecimal.format(numero1 * numero2));
                                numero1Final = "a";
                                numero2Final = String.valueOf(numero2);
                                break;

                            case "/":
                                resultado = Double.valueOf(form.format((double) numero1 / numero2));
                                numero1Final = "a";
                                numero2Final = String.valueOf(numero2);
                                break;

                        }
                        break;

                    case "b":

                        switch (valorOperacionElegido) {

                            case "+":
                                resultado = Double.valueOf(formNoDecimal.format(numero1 + numero2));
                                numero1Final = String.valueOf(numero1);
                                numero2Final = "b";
                                break;

                            case "-":
                                resultado = Double.valueOf(formNoDecimal.format(numero1 - numero2));
                                numero1Final = String.valueOf(numero1);
                                numero2Final = "b";
                                break;

                            case "*":
                                resultado = Double.valueOf(formNoDecimal.format(numero1 * numero2));
                                numero1Final = String.valueOf(numero1);
                                numero2Final = "b";
                                break;

                            case "/":
                                resultado = Double.valueOf(form.format((double) numero1 / numero2));
                                numero1Final = String.valueOf(numero1);
                                numero2Final = "b";
                                break;

                        }
                        break;

                }

                break;

        }

        if (!valorOperacion.equals("a,b")) {

            numero1Final = String.valueOf(numero1);
            numero2Final = String.valueOf(numero2);

        } else {

            TextView textoIgual = findViewById(R.id.igualA);
            textoResultado = findViewById(R.id.textoResultado);

            textoIgual.setText("=");

            if (!valorOperacionElegido.equals("/")){

                resultadoInt = Integer.valueOf((int) resultado);
                resultadoFinal = String.valueOf(resultadoInt);

            } else {

                resultadoFinal = String.valueOf(resultado);

            }

            textoResultado.setText(resultadoFinal);

        }

        textoNumero1.setText(numero1Final);
        textoNumero2.setText(numero2Final);

        TextView aciertos = findViewById(R.id.aciertos);
        TextView fallos = findViewById(R.id.fallos);

        aciertos.setText(String.valueOf(acierto));
        fallos.setText(String.valueOf(fallo));

        Button boton1 = findViewById(R.id.botonMates1);
        Button boton2 = findViewById(R.id.botonMates2);
        Button boton3 = findViewById(R.id.botonMates3);

        numboton1 = Double.valueOf(form.format(Double.valueOf(boton1.getText().toString())));
        numboton2 = Double.valueOf(form.format(Double.valueOf(boton2.getText().toString())));
        numboton3 = Double.valueOf(form.format(Double.valueOf(boton3.getText().toString())));

        numboton1 = (int) ((Math.random() * 100) + 1);
        numboton2 = (int) ((Math.random() * 100) + 1);
        numboton3 = (int) ((Math.random() * 100) + 1);

         do {

            botonCorrecto = (int) Math.floor(Math.random() * 3 + 1);

            switch (botonCorrecto) {

                case 1:

                    if (!valorOperacion.equals("a,b")) {

                        numboton1 = resultado;
                        numboton2 = (int) ((Math.random() * 100) + 1);
                        numboton3 = (int) ((Math.random() * 100) + 1);

                    } else {

                        switch (letraElegida) {

                            case "a":

                                numboton1 = numero1;
                                numboton2 = (int) ((Math.random() * 100) + 1);
                                numboton3 = (int) ((Math.random() * 100) + 1);
                                break;

                            case "b":

                                numboton1 = numero2;
                                numboton2 = (int) ((Math.random() * 100) + 1);
                                numboton3 = (int) ((Math.random() * 100) + 1);
                                break;

                        }

                    }
                    break;

                case 2:

                    if (!valorOperacion.equals("a,b")) {

                        numboton2 = resultado;
                        numboton1 = (int) ((Math.random() * 100) + 1);
                        numboton3 = (int) ((Math.random() * 100) + 1);

                    } else {

                        switch (letraElegida) {

                            case "a":

                                numboton2 = numero1;
                                numboton1 = (int) ((Math.random() * 100) + 1);
                                numboton3 = (int) ((Math.random() * 100) + 1);
                                break;

                            case "b":

                                numboton2 = numero2;
                                numboton1 = (int) ((Math.random() * 100) + 1);
                                numboton3 = (int) ((Math.random() * 100) + 1);
                                break;

                        }

                    }

                    break;

                case 3:

                    if (!valorOperacion.equals("a,b")) {

                        numboton3 = resultado;
                        numboton1 = (int) ((Math.random() * 100) + 1);
                        numboton2 = (int) ((Math.random() * 100) + 1);

                    } else {

                        switch (letraElegida) {

                            case "a":

                                numboton3 = numero1;
                                numboton1 = (int) ((Math.random() * 100) + 1);
                                numboton2 = (int) ((Math.random() * 100) + 1);
                                break;

                            case "b":

                                numboton3 = numero2;
                                numboton1 = (int) ((Math.random() * 100) + 1);
                                numboton2 = (int) ((Math.random() * 100) + 1);
                                break;

                        }

                    }

                    break;

            }

        } while (numboton1 == numboton2 || numboton1 == numboton3 || numboton2 == numboton3);

         boton1.setText(String.valueOf(numboton1));
         boton2.setText(String.valueOf(numboton2));
         boton3.setText(String.valueOf(numboton3));

        boton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (!valorOperacion.equals("a,b")) {

                    if (resultado == numboton1) {

                        acierto = acierto + 1;
                        aciertos.setText(String.valueOf(acierto));

                    } else {

                        fallo = fallo + 1;
                        fallos.setText(String.valueOf(fallo));

                    }

                } else {

                    switch (letraElegida) {

                        case "a":

                            if (numero1 == numboton1) {

                                acierto = acierto + 1;
                                aciertos.setText(String.valueOf(acierto));

                            } else {

                                fallo = fallo + 1;
                                fallos.setText(String.valueOf(fallo));

                            }
                            break;

                        case "b":

                            if (numero2 == numboton1) {

                                acierto = acierto + 1;
                                aciertos.setText(String.valueOf(acierto));

                            } else {

                                fallo = fallo + 1;
                                fallos.setText(String.valueOf(fallo));

                            }
                            break;

                    }

                }

                numero1 = (int) ((Math.random() * 10) + 1);
                numero2 = (int) ((Math.random() * 10) + 1);

                textoNumero1.setText(String.valueOf(numero1));
                textoNumero2.setText(String.valueOf(numero2));

                if(valorOperacion.equals("+,-,*,/") || valorOperacion.equals("a,b")) {

                    valorOperacionElegido = variado[(int) Math.floor(Math.random() * variado.length)];
                    textoOperacion.setText(valorOperacionElegido);

                }

                switch (valorOperacion) {

                    case "+":
                        resultado = numero1 + numero2;
                        break;

                    case "-":
                        resultado = numero1 - numero2;
                        break;

                    case "*":
                        resultado = numero1 * numero2;
                        break;

                    case "/":
                        resultado = Double.valueOf(form.format((double) numero1 / numero2));
                        break;

                    case "+,-,*,/":

                        switch (valorOperacionElegido) {

                            case "+":
                                resultado = numero1 + numero2;
                                break;

                            case "-":
                                resultado = numero1 - numero2;
                                break;

                            case "*":
                                resultado = numero1 * numero2;
                                break;

                            case "/":
                                resultado = Double.valueOf(form.format((double) numero1 / numero2));
                                break;

                        }
                        break;

                    case "a,b":

                        letraElegida = algebra[(int) Math.floor(Math.random() * algebra.length)];

                        switch (letraElegida) {

                            case "a":

                                switch (valorOperacionElegido) {

                                    case "+":
                                        resultado = Double.valueOf(formNoDecimal.format(numero1 + numero2));
                                        numero1Final = "a";
                                        numero2Final = String.valueOf(numero2);
                                        break;

                                    case "-":
                                        resultado = Double.valueOf(formNoDecimal.format(numero1 - numero2));
                                        numero1Final = "a";
                                        numero2Final = String.valueOf(numero2);
                                        break;

                                    case "*":
                                        resultado = Double.valueOf(formNoDecimal.format(numero1 * numero2));
                                        numero1Final = "a";
                                        numero2Final = String.valueOf(numero2);
                                        break;

                                    case "/":
                                        resultado = Double.valueOf(form.format((double) numero1 / numero2));
                                        numero1Final = "a";
                                        numero2Final = String.valueOf(numero2);
                                        break;

                                }
                                break;

                            case "b":

                                switch (valorOperacionElegido) {

                                    case "+":
                                        resultado = Double.valueOf(formNoDecimal.format(numero1 + numero2));
                                        numero1Final = String.valueOf(numero1);
                                        numero2Final = "b";
                                        break;

                                    case "-":
                                        resultado = Double.valueOf(formNoDecimal.format(numero1 - numero2));
                                        numero1Final = String.valueOf(numero1);
                                        numero2Final = "b";
                                        break;

                                    case "*":
                                        resultado = Double.valueOf(formNoDecimal.format(numero1 * numero2));
                                        numero1Final = String.valueOf(numero1);
                                        numero2Final = "b";
                                        break;

                                    case "/":
                                        resultado = Double.valueOf(form.format((double) numero1 / numero2));
                                        numero1Final = String.valueOf(numero1);
                                        numero2Final = "b";
                                        break;

                                }
                                break;

                        }

                        break;

                }



                 do {

                    botonCorrecto = (int) Math.floor(Math.random() * 3 + 1);

                    switch (botonCorrecto) {

                        case 1:

                            if (!valorOperacion.equals("a,b")) {

                                numboton1 = resultado;
                                numboton2 = (int) ((Math.random() * 100) + 1);
                                numboton3 = (int) ((Math.random() * 100) + 1);

                            } else {

                                switch (letraElegida) {

                                    case "a":

                                        numboton1 = numero1;
                                        numboton2 = (int) ((Math.random() * 100) + 1);
                                        numboton3 = (int) ((Math.random() * 100) + 1);
                                        break;

                                    case "b":

                                        numboton1 = numero2;
                                        numboton2 = (int) ((Math.random() * 100) + 1);
                                        numboton3 = (int) ((Math.random() * 100) + 1);
                                        break;

                                }

                            }
                            break;

                        case 2:

                            if (!valorOperacion.equals("a,b")) {

                                numboton2 = resultado;
                                numboton1 = (int) ((Math.random() * 100) + 1);
                                numboton3 = (int) ((Math.random() * 100) + 1);

                            } else {

                                switch (letraElegida) {

                                    case "a":

                                        numboton2 = numero1;
                                        numboton1 = (int) ((Math.random() * 100) + 1);
                                        numboton3 = (int) ((Math.random() * 100) + 1);
                                        break;

                                    case "b":

                                        numboton2 = numero2;
                                        numboton1 = (int) ((Math.random() * 100) + 1);
                                        numboton3 = (int) ((Math.random() * 100) + 1);
                                        break;

                                }

                            }

                            break;

                        case 3:

                            if (!valorOperacion.equals("a,b")) {

                                numboton3 = resultado;
                                numboton1 = (int) ((Math.random() * 100) + 1);
                                numboton2 = (int) ((Math.random() * 100) + 1);

                            } else {

                                switch (letraElegida) {

                                    case "a":

                                        numboton3 = numero1;
                                        numboton1 = (int) ((Math.random() * 100) + 1);
                                        numboton2 = (int) ((Math.random() * 100) + 1);
                                        break;

                                    case "b":

                                        numboton3 = numero2;
                                        numboton1 = (int) ((Math.random() * 100) + 1);
                                        numboton2 = (int) ((Math.random() * 100) + 1);
                                        break;

                                }

                            }

                            break;

                    }

                }while (numboton1 == numboton2 || numboton1 == numboton3 || numboton2 == numboton3);

                if (valorOperacion.equals("a,b")) {

                    textoNumero1.setText(numero1Final);
                    textoNumero2.setText(numero2Final);

                    if (!valorOperacionElegido.equals("/")){

                        resultadoInt = Integer.valueOf((int) resultado);
                        resultadoFinal = String.valueOf(resultadoInt);

                    } else {

                        resultadoFinal = String.valueOf(resultado);

                    }

                    textoResultado.setText(resultadoFinal);

                }

                boton1.setText(String.valueOf(numboton1));
                boton2.setText(String.valueOf(numboton2));
                boton3.setText(String.valueOf(numboton3));

            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (!valorOperacion.equals("a,b")) {

                    if (resultado == numboton2) {

                        acierto = acierto + 1;
                        aciertos.setText(String.valueOf(acierto));

                    } else {

                        fallo = fallo + 1;
                        fallos.setText(String.valueOf(fallo));

                    }

                } else {

                    switch (letraElegida) {

                        case "a":

                            if (numero1 == numboton2) {

                                acierto = acierto + 1;
                                aciertos.setText(String.valueOf(acierto));

                            } else {

                                fallo = fallo + 1;
                                fallos.setText(String.valueOf(fallo));

                            }
                            break;

                        case "b":

                            if (numero2 == numboton2) {

                                acierto = acierto + 1;
                                aciertos.setText(String.valueOf(acierto));

                            } else {

                                fallo = fallo + 1;
                                fallos.setText(String.valueOf(fallo));

                            }
                            break;

                    }

                }

                numero1 = (int) ((Math.random() * 10) + 1);
                numero2 = (int) ((Math.random() * 10) + 1);

                textoNumero1.setText(String.valueOf(numero1));
                textoNumero2.setText(String.valueOf(numero2));

                if(valorOperacion.equals("+,-,*,/")) {

                    valorOperacionElegido = variado[(int) Math.floor(Math.random() * variado.length)];
                    textoOperacion.setText(valorOperacionElegido);

                }

                switch (valorOperacion) {

                    case "+":
                        resultado = numero1 + numero2;
                        break;

                    case "-":
                        resultado = numero1 - numero2;
                        break;

                    case "*":
                        resultado = numero1 * numero2;
                        break;

                    case "/":
                        resultado = Double.valueOf(form.format((double) numero1 / numero2));
                        break;

                    case "+,-,*,/":

                        switch (valorOperacionElegido) {

                            case "+":
                                resultado = numero1 + numero2;
                                break;

                            case "-":
                                resultado = numero1 - numero2;
                                break;

                            case "*":
                                resultado = numero1 * numero2;
                                break;

                            case "/":
                                resultado = Double.valueOf(form.format((double) numero1 / numero2));
                                break;

                        }
                        break;

                    case "a,b":

                        letraElegida = algebra[(int) Math.floor(Math.random() * algebra.length)];

                        switch (letraElegida) {

                            case "a":

                                switch (valorOperacionElegido) {

                                    case "+":
                                        resultado = Double.valueOf(formNoDecimal.format(numero1 + numero2));
                                        numero1Final = "a";
                                        numero2Final = String.valueOf(numero2);
                                        break;

                                    case "-":
                                        resultado = Double.valueOf(formNoDecimal.format(numero1 - numero2));
                                        numero1Final = "a";
                                        numero2Final = String.valueOf(numero2);
                                        break;

                                    case "*":
                                        resultado = Double.valueOf(formNoDecimal.format(numero1 * numero2));
                                        numero1Final = "a";
                                        numero2Final = String.valueOf(numero2);
                                        break;

                                    case "/":
                                        resultado = Double.valueOf(form.format((double) numero1 / numero2));
                                        numero1Final = "a";
                                        numero2Final = String.valueOf(numero2);
                                        break;

                                }
                                break;

                            case "b":

                                switch (valorOperacionElegido) {

                                    case "+":
                                        resultado = Double.valueOf(formNoDecimal.format(numero1 + numero2));
                                        numero1Final = String.valueOf(numero1);
                                        numero2Final = "b";
                                        break;

                                    case "-":
                                        resultado = Double.valueOf(formNoDecimal.format(numero1 - numero2));
                                        numero1Final = String.valueOf(numero1);
                                        numero2Final = "b";
                                        break;

                                    case "*":
                                        resultado = Double.valueOf(formNoDecimal.format(numero1 * numero2));
                                        numero1Final = String.valueOf(numero1);
                                        numero2Final = "b";
                                        break;

                                    case "/":
                                        resultado = Double.valueOf(form.format((double) numero1 / numero2));
                                        numero1Final = String.valueOf(numero1);
                                        numero2Final = "b";
                                        break;

                                }
                                break;

                        }

                        break;

                }

                do {

                    botonCorrecto = (int) Math.floor(Math.random() * 3 + 1);

                    switch (botonCorrecto) {

                        case 1:

                            if (!valorOperacion.equals("a,b")) {

                                numboton1 = resultado;
                                numboton2 = (int) ((Math.random() * 100) + 1);
                                numboton3 = (int) ((Math.random() * 100) + 1);

                            } else {

                                switch (letraElegida) {

                                    case "a":

                                        numboton1 = numero1;
                                        numboton2 = (int) ((Math.random() * 100) + 1);
                                        numboton3 = (int) ((Math.random() * 100) + 1);
                                        break;

                                    case "b":

                                        numboton1 = numero2;
                                        numboton2 = (int) ((Math.random() * 100) + 1);
                                        numboton3 = (int) ((Math.random() * 100) + 1);
                                        break;

                                }

                            }
                            break;

                        case 2:

                            if (!valorOperacion.equals("a,b")) {

                                numboton2 = resultado;
                                numboton1 = (int) ((Math.random() * 100) + 1);
                                numboton3 = (int) ((Math.random() * 100) + 1);

                            } else {

                                switch (letraElegida) {

                                    case "a":

                                        numboton2 = numero1;
                                        numboton1 = (int) ((Math.random() * 100) + 1);
                                        numboton3 = (int) ((Math.random() * 100) + 1);
                                        break;

                                    case "b":

                                        numboton2 = numero2;
                                        numboton1 = (int) ((Math.random() * 100) + 1);
                                        numboton3 = (int) ((Math.random() * 100) + 1);
                                        break;

                                }

                            }

                            break;

                        case 3:

                            if (!valorOperacion.equals("a,b")) {

                                numboton3 = resultado;
                                numboton1 = (int) ((Math.random() * 100) + 1);
                                numboton2 = (int) ((Math.random() * 100) + 1);

                            } else {

                                switch (letraElegida) {

                                    case "a":

                                        numboton3 = numero1;
                                        numboton1 = (int) ((Math.random() * 100) + 1);
                                        numboton2 = (int) ((Math.random() * 100) + 1);
                                        break;

                                    case "b":

                                        numboton3 = numero2;
                                        numboton1 = (int) ((Math.random() * 100) + 1);
                                        numboton2 = (int) ((Math.random() * 100) + 1);
                                        break;

                                }

                            }

                            break;

                    }

                }while (numboton1 == numboton2 || numboton1 == numboton3 || numboton2 == numboton3);

                if (valorOperacion.equals("a,b")) {

                    textoNumero1.setText(numero1Final);
                    textoNumero2.setText(numero2Final);

                    if (!valorOperacionElegido.equals("/")){

                        resultadoInt = Integer.valueOf((int) resultado);
                        resultadoFinal = String.valueOf(resultadoInt);

                    } else {

                        resultadoFinal = String.valueOf(resultado);

                    }

                    textoResultado.setText(resultadoFinal);

                }

                boton1.setText(String.valueOf(numboton1));
                boton2.setText(String.valueOf(numboton2));
                boton3.setText(String.valueOf(numboton3));

            }
        });

        boton3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (!valorOperacion.equals("a,b")) {

                    if (resultado == numboton3) {

                        acierto = acierto + 1;
                        aciertos.setText(String.valueOf(acierto));

                    } else {

                        fallo = fallo + 1;
                        fallos.setText(String.valueOf(fallo));

                    }

                } else {

                    switch (letraElegida) {

                        case "a":

                            if (numero1 == numboton3) {

                                acierto = acierto + 1;
                                aciertos.setText(String.valueOf(acierto));

                            } else {

                                fallo = fallo + 1;
                                fallos.setText(String.valueOf(fallo));

                            }
                            break;

                        case "b":

                            if (numero2 == numboton3) {

                                acierto = acierto + 1;
                                aciertos.setText(String.valueOf(acierto));

                            } else {

                                fallo = fallo + 1;
                                fallos.setText(String.valueOf(fallo));

                            }
                            break;

                    }

                }

                numero1 = (int) ((Math.random() * 10) + 1);
                numero2 = (int) ((Math.random() * 10) + 1);

                textoNumero1.setText(String.valueOf(numero1));
                textoNumero2.setText(String.valueOf(numero2));

                if(valorOperacion.equals("+,-,*,/")) {

                    valorOperacionElegido = variado[(int) Math.floor(Math.random() * variado.length)];
                    textoOperacion.setText(valorOperacionElegido);

                }

                switch (valorOperacion) {

                    case "+":
                        resultado = numero1 + numero2;
                        break;

                    case "-":
                        resultado = numero1 - numero2;
                        break;

                    case "*":
                        resultado = numero1 * numero2;
                        break;

                    case "/":
                        resultado = Double.valueOf(form.format((double) numero1 / numero2));
                        break;

                    case "+,-,*,/":

                        switch (valorOperacionElegido) {

                            case "+":
                                resultado = numero1 + numero2;
                                break;

                            case "-":
                                resultado = numero1 - numero2;
                                break;

                            case "*":
                                resultado = numero1 * numero2;
                                break;

                            case "/":
                                resultado = Double.valueOf(form.format((double) numero1 / numero2));
                                break;

                        }
                        break;

                    case "a,b":

                        letraElegida = algebra[(int) Math.floor(Math.random() * algebra.length)];

                        switch (letraElegida) {

                            case "a":

                                switch (valorOperacionElegido) {

                                    case "+":
                                        resultado = Double.valueOf(formNoDecimal.format(numero1 + numero2));
                                        numero1Final = "a";
                                        numero2Final = String.valueOf(numero2);
                                        break;

                                    case "-":
                                        resultado = Double.valueOf(formNoDecimal.format(numero1 - numero2));
                                        numero1Final = "a";
                                        numero2Final = String.valueOf(numero2);
                                        break;

                                    case "*":
                                        resultado = Double.valueOf(formNoDecimal.format(numero1 * numero2));
                                        numero1Final = "a";
                                        numero2Final = String.valueOf(numero2);
                                        break;

                                    case "/":
                                        resultado = Double.valueOf(form.format((double) numero1 / numero2));
                                        numero1Final = "a";
                                        numero2Final = String.valueOf(numero2);
                                        break;

                                }
                                break;

                            case "b":

                                switch (valorOperacionElegido) {

                                    case "+":
                                        resultado = Double.valueOf(formNoDecimal.format(numero1 + numero2));
                                        numero1Final = String.valueOf(numero1);
                                        numero2Final = "b";
                                        break;

                                    case "-":
                                        resultado = Double.valueOf(formNoDecimal.format(numero1 - numero2));
                                        numero1Final = String.valueOf(numero1);
                                        numero2Final = "b";
                                        break;

                                    case "*":
                                        resultado = Double.valueOf(formNoDecimal.format(numero1 * numero2));
                                        numero1Final = String.valueOf(numero1);
                                        numero2Final = "b";
                                        break;

                                    case "/":
                                        resultado = Double.valueOf(form.format((double) numero1 / numero2));
                                        numero1Final = String.valueOf(numero1);
                                        numero2Final = "b";
                                        break;

                                }
                                break;

                        }


                        break;

                }

                do {

                    botonCorrecto = (int) Math.floor(Math.random() * 3 + 1);

                    switch (botonCorrecto) {

                        case 1:

                            if (!valorOperacion.equals("a,b")) {

                                numboton1 = resultado;
                                numboton2 = (int) ((Math.random() * 100) + 1);
                                numboton3 = (int) ((Math.random() * 100) + 1);

                            } else {

                                switch (letraElegida) {

                                    case "a":

                                        numboton1 = numero1;
                                        numboton2 = (int) ((Math.random() * 100) + 1);
                                        numboton3 = (int) ((Math.random() * 100) + 1);
                                        break;

                                    case "b":

                                        numboton1 = numero2;
                                        numboton2 = (int) ((Math.random() * 100) + 1);
                                        numboton3 = (int) ((Math.random() * 100) + 1);
                                        break;

                                }

                            }
                            break;

                        case 2:

                            if (!valorOperacion.equals("a,b")) {

                                numboton2 = resultado;
                                numboton1 = (int) ((Math.random() * 100) + 1);
                                numboton3 = (int) ((Math.random() * 100) + 1);

                            } else {

                                switch (letraElegida) {

                                    case "a":

                                        numboton2 = numero1;
                                        numboton1 = (int) ((Math.random() * 100) + 1);
                                        numboton3 = (int) ((Math.random() * 100) + 1);
                                        break;

                                    case "b":

                                        numboton2 = numero2;
                                        numboton1 = (int) ((Math.random() * 100) + 1);
                                        numboton3 = (int) ((Math.random() * 100) + 1);
                                        break;

                                }

                            }

                            break;

                        case 3:

                            if (!valorOperacion.equals("a,b")) {

                                numboton3 = resultado;
                                numboton1 = (int) ((Math.random() * 100) + 1);
                                numboton2 = (int) ((Math.random() * 100) + 1);

                            } else {

                                switch (letraElegida) {

                                    case "a":

                                        numboton3 = numero1;
                                        numboton1 = (int) ((Math.random() * 100) + 1);
                                        numboton2 = (int) ((Math.random() * 100) + 1);
                                        break;

                                    case "b":

                                        numboton3 = numero2;
                                        numboton1 = (int) ((Math.random() * 100) + 1);
                                        numboton2 = (int) ((Math.random() * 100) + 1);
                                        break;

                                }

                            }

                            break;

                    }

                }while (numboton1 == numboton2 || numboton1 == numboton3 || numboton2 == numboton3);

                if (valorOperacion.equals("a,b")) {

                    textoNumero1.setText(numero1Final);
                    textoNumero2.setText(numero2Final);

                    if (!valorOperacionElegido.equals("/")){

                        resultadoInt = Integer.valueOf((int) resultado);
                        resultadoFinal = String.valueOf(resultadoInt);

                    } else {

                        resultadoFinal = String.valueOf(resultado);

                    }

                    textoResultado.setText(resultadoFinal);

                }

                boton1.setText(String.valueOf(numboton1));
                boton2.setText(String.valueOf(numboton2));
                boton3.setText(String.valueOf(numboton3));

            }
        });

    }
}