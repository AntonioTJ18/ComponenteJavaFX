Practica 3.2

Componente javafx, este componente se basa en un circulo que cambia los colores según el radio button que se use. por defecto este empieza en un color naranja y segun el boton seleccionado se puede cambiar a color verde agua que en hexadecimal es el "52FFCE", tambien puede ser un verde claro que en hexadecimal es "C5FF8F" y su ultimo color seleccionable es el rosa que en hexadecimal es "FF8FD8".

Para poder hacer este componente lo principal es crear tres clases principles que nos van ha permitir poder crear el componente, crear el evento de cambio de color y el controlador que es donde se programa los colores a cambiar en nuestro componente.

// Parte del evento
-Lo primero sera crear los eventos ya que los componetes van creados en domino es decir sin evento, no se puede crear controlador y sin controlador el componente, y que necesitamos para crear este evento pues necesitaremos crear una clase que a poder ser se llama EventoCambiaColor y que herede de evento y luego necesitamos las variables de controlador de versiones que es el variable estatica de tipo long que lo llamaremos serialVersion y le pondremos de valor 1L, la siguiente variable sera publica y estatica y este sera el encargado de crear la variable evento que debe ser tipo "EventType<Nombre_de_la_clase>" y este de ser iniciado con un "new EventType<>(Event.ANY, "Accion_que_realiza_el_Evento")" y por ultimo una variable Paint que deberiamos llamarla pintura o algo distintivo.

Luego crearemos un constructor que nos pedira de entrada una variable de pintura, luego debemos usar el super ya que recordemos estamos heradando de Event y luego de eso actualizaremos nuestra variable de pintura con la que recibimos de fuera. Una vez echo el constructor lo que haremos sera un getPintura para en algun caso acceder a la variable pintura ya que esta variable es privada.

Y nuestro segundo evento nos permitira que nuestro circulo se pueda mover de manera aleatoria por la pantalla este debe contner lo mismo que el otro evento pero cambiando el nombre por mover.

// Parte del controlador
-Lo segundo que debemos crear es nuestro controlador que puede tener cualquier nombre pero lo recomendable es poner controlador mas el nombre de componente que vamos crear, y que va contener nuestro controlador pues debe tener todos los elementos de nuestro componente en nuestro caso seria un atributo circulo, un grupo de radio button, los radio butom que seran con los que mas adelante podremos cambiar el color. Y para controlar la parte del movimiento vamos a necesitar las variables de un boton de reinicio y una variable aleatoria que nos permita que al clicar uno de los radio se mueva aleatoriamente. 

Lo siguiente que haremos sera crear el eventos que lo unico que contiene es un cambio de color segun el radio button y una pintura que contiene el color que cambiaremos y como sabemos si esta pulsado o no pues es muy sencillo con la accion isSelected esta se usa como bandera y si esta selecionada pues la pintura debe cambiar al color que nosotros le indiquemos con la sentencia "Nombre_variable_pintura = Paint.valueOf("color en hexadecimal")" eso lo repetimos con todos los radio button que tengamos. Para que nuestro componente circulo pueda cambiar debemos finalirzar el evento con las sentecias "nombre_variable_circulo.setFill(pintura)" que esta nos actualizara el color del circulo y por ultimo necesitamos lanzar el evento y eso lo haremos con la sentencia "nombre_variable_circulo.fireEvent(new EventoCambioColor(nombre_variable_pintura))" usamos la clase evento que creamos antes.

Y ahora para hacer es un metodo que limite el movimiento del circulo para que este no se mueva de manera muy rapida por la pantalla, lo siguiente que haremos para que se pueda mover aleatoriamente despues de pulsar un color es añadir los siguientes parametros al metodo principal de "color_circle", debemos añadir dos variables double que nos marcara el movimiento de nuestro circulo que seran nuestra X e Y, lo debemos poner en de la siguiente manera "double dx o dy=  random.nextDouble() * 200 - 100;", una vez puesto esto dos double de esta manera lo que haremos sera crear una variable que es la que nos va hacer poder moverse y esta es "TranslateTransition nombre_de_la_variable = new TranslateTransition(Duration.millis(cantidad_de_milisegundos_de_la_animacion), circulo)" y esta se debe actualizar con nuestros dos doubles de antes por eso uno es X y el otro Y, debemos poner lo siguiente:
		"tt.setByX(variable_correspondiente_X);
		 tt.setByY(variable_correspondiente_Y);"
Luego de poner estas dos instruciones para que nuestro circulo sepa donde se tiene que mover debemos hacer que nuestra variable Trasnlate se ejecute y para ello tenemos que poner "tt.play();". Por ultimo lo que haremos sera llamar a nuestro metodo "limitarMovimiento" y al fireEvent para asi ya finalizar todo.

Lo ultimo que implementaremos sera un boton de reinicio porque si queremos que nuestro circulo vuelva a su posicion original, para ello solo necesitamos un metodo nuevo que lo llamaremo "reiniciarPosicion" que es un evento igual que nuestro evento de "color_circle", este es muy sencillo solo necesitamos crear una variable TranslateTransition y como antes debemos crearla con el tiempo de animacion todo en milisegundos y nuestra X e Y deben estar a cero cuando usemos el "setByX y setByY".

// Parte del componente 
-Por ultimo la clase componente debe tener ser heredada de un Pane o Vbox esto depende de lo que usemos en el FXML, la primera y unica varible necesaria en esta clase sera de la clase controlador previamente creada que la nombraremos controlador y luego crearemos un constructor que nos permitra cargar los eventos del XML que nosostros hemos implementado en el FXML con la variable FMXLLoader, esta la usaremos con las siguiente sentencias:
    "loader.setRoot(this);
	 loader.setController(this.controlador);
	 loader.setLocation(getClass().getResource("/Carpeta_principal_del_proyecto_en_la_carpeta_java/carpeta_donde_se_guarda_el_componente/Nombre_del_FXLM.fxml"));
	 loader.load();"
Todo esto lo debemos tener metido en try catch ya que puede darnos una excepción que la trataremos en el catch con la sentencia nombre_del_parametro_de_la_excepción.printStackTrace(). Y con eso tendriamos todo creado y funcionaria nuestro componente. 

// Parte del FXML
Una vez explicado los archivos necesarios para crear el componente vamos a explicar como hacer el apartado grafico de este mismo y que sea funcional a lo que nosotros hemos echo anteriormente, necesitamos un fxml con lo siguiente:
	"<fx:root maxHeight="-Infinity" maxWidth="-Infinity" minHeight="-Infinity" minWidth="-Infinity" prefHeight="Tamaño_que_mas_nos_guste_o_necesitemos" prefWidth="Tamaño_que_mas_nos_guste_o_necesitemos" type="Puede ser un Pane o un Vbox" xmlns="http://javafx.com/javafx/25" xmlns:fx="http://javafx.com/fxml/1">"
Que es lo que hace esta linea exactamente pues lo que hace es describir el nodo principal de nuestro archivo FXML que nuestro caso es el Pane pero tambien podria ser un Vbox, en nuestra linea root tambien hemos puesto un tamaño predefinido y pero tambien sin restricciones. 

Despues de nuestra linea principal vamos crear nuestras variables que antes hemos mencionado cual va ser la primera pues nuestro boton de reinicio que este se comprondra de los siguiente:
	"<Button layoutX="88.0" layoutY="104.0" onAction="#reiniciarPosicion" text="Reiniciar posición" />"
Que contiene esta linea pues tiene el tamaño del boton, la accion que va realizar que debe ser un metodo de la clase controladora y el texto que este vaya a tener. Lo siguiente sera nuestro grupo de radio button, los propios radio button pues estos se deben poner de la siguiente: 
	 "<RadioButton fx:id="rb_rosa" layoutX="10.0" layoutY="14.0" mnemonicParsing="false" onAction="#color_circle" text="Rosa">
         <toggleGroup>
            <ToggleGroup fx:id="colores" />
         </toggleGroup>
      </RadioButton>
      <RadioButton fx:id="rb_verde_azulado" layoutX="10.0" layoutY="39.0" mnemonicParsing="false" onAction="#color_circle" text="Verde Agua" toggleGroup="$colores" />
      <RadioButton fx:id="rb_verde" layoutX="10.0" layoutY="64.0" mnemonicParsing="false" onAction="#color_circle" text="Verde" toggleGroup="$colores" />"
Pues que hace todo esto pues engloba todo el grupo de radio button, y cada radio button tiene un tamaño que puede ser cualquiera, un texto y estos acceden a la accion del controlador "color_circle" todos estos pertenencen al grupo de radio button "colores" el nombre puede ser cualquiera pero a poder ser algo significativo.

Y por ultimo nuestro circulo que este es muy sencillo de poner y se hace de la siguiente manera: 
	"<Circle fx:id="circulo" fill="#FFAB57" layoutX="142.0" layoutY="48.0" radius="40.0" stroke="BLACK" strokeType="INSIDE" />"
Nuestro circulo empieza con color base, un tamaño a elegir, un borde que tambien podemos elegir el color que nosotros queramos, y por ultimo el contorno de esta figura.

