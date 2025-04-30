# proyectointegrado2425-rnunher1411
proyectointegrado2425-rnunher1411 created by GitHub Classroom

## TRIVIALDROID


### Pantalla de inicio

Se trata de un programa educativo que ofrece ejercicios simples de matemáticas e inglés simples, centrados en el nivel de primaria y secundaria.

![Primera foto del proyecto](/Maqueta_de_proyecto_Figma/frame1.jpg)


Al principio podrás elegir cual de las dos asignaturas deseas seleccionar para practicar. Por eso dividiremos la explicación en cada una de ellas:


### Matemáticas

![Segunda foto del proyecto](/Maqueta_de_proyecto_Figma/frame2.jpg)

Al elegir matemáticas tendrás que elegir cuál será la condición de las operaciones (suma, resta, multiplicación, división, las cuatro antes mencionadas al mismo tiempo o álgebra) y por cuanto tiempo desees que dure la sesión (de uno a cinco minutos). 

Tras haber decidido las opciones podrá iniciar tras pulsar el botón.

![Tercera foto del proyecto](/Maqueta_de_proyecto_Figma/frame3.jpg)

El temporizador mostrará el tiempo asignado en las opciones y cuando este llegue a cero pasaremos a la pantalla de resultados. También podrás vislumbrar a tiempo real los aciertos y fallos llevados por el momento.

En el centro de la pantalla ocurre la actividad principal donde aparecerán dos números aleatorios y la operación seleccionada en las opciones (si eliges álgebra uno de los números será sustituido por una letra y se podrá ver el resultado de dicha operación). 

Abajo hay 3 botones con cada uno un resultado diferente, uno de ellos es el correcto y los otros dos falso (en álgebra el botón correcto es el valor de la letra en la operación),la posición del botón correcto siempre es aleatoria y podrás saber si fallaste o no al momento al ver la puntuación.

Obviamente la operación cambiará a una con diferentes números (y operaciones si eliges la opción de varios operadores o álgebra) cada vez que pulses un botón.


### Inglés

Al elegir inglés tendrás que elegir cuál será el nivel de idioma de la actividad, en este caso al poder elegir más de uno a la vez decidí mostrarlo como Checkboxes en vez de un Spinner.
También debes elegir si el idioma de las frases que deberás traducir al otro idioma estarán en español o en inglés. 

Tras haber decidido las opciones podrá iniciar tras pulsar el botón.


El temporizador mostrará el tiempo de la actividad (en esta asignatura siempre durará 5 minutos) y cuando este llegue a cero pasaremos a la pantalla de resultados. También podrás vislumbrar a tiempo real los aciertos y fallos llevados por el momento. A diferencia de matemáticas los errores y aciertos sólo se aplicarán al pulsar el botón de Comprobar traducción (el botón solo funcionará una vez por frase).

En el centro de la pantalla ocurre la actividad principal donde aparecerá una frase (en español o inglés dependiendo del idioma establecido en las opciones) y un Edit text en donde podemos traducir la frase. Las frases se irán presentando de forma aleatoria y solo aparecerán las frases de los niveles elegidos en las opciones. 

Antes de pasar a la siguiente frase hay que primero pulsar el botón de Comprobar traducción, después de interactuar con el botón aparecerá una frase debajo del Edit text el cuál es la traducción correcta de la frase inicial. Si es diferente al texto escrito en el Edit text consigues un fallo, en el caso contrario obtienes un acierto. 

Al pulsar el botón Siguiente frase el Edit Text se vacía, la frase cambia, su traducción desaparece y el botón Comprobar traducción vuelve a estar habilitado.  

En el caso que logres traducir a tiempo todas las frases disponibles también darás por terminado la actividad entrando a la pantalla de resultados finales sin necesidad de que el cronómetro llegue a 0.


### Pantalla resultados finales

![Sexta foto del proyecto](/Maqueta_de_proyecto_Figma/frame4.jpg)

Al acabarse el tiempo en la actividad de algunas de las asignaturas llegarás a esta pantalla que te felicitará por acabar la actividad, te dirá el resultado final y podrás pulsar el botón de reiniciar la sesión (te llevará a la pantalla de opciones de la asignatura) o el botón de inicio (que te llevará devuelta a la selección de asignaturas).
