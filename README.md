Practica 3.1

Componente javafx, este componente se basa en un circulo que cambia los colores según el radio button que se use. por defecto este empieza en un color naranja y segun el boton seleccionado se puede cambiar a color verde agua que en hexadecimal es el "52FFCE", tambien puede ser un verde claro que en hexadecimal es "C5FF8F" y su ultimo color seleccionable es el rosa que en hexadecimal es "FF8FD8".

Para poder hacer este componente lo principal es crear tres clases principles que nos van ha permitir poder crear el componente, crear el evento de cambio de color y el controlador que es donde se programa los colores a cambiar en nuestro componente.

-Lo primero sera crear el evento ya que los componetes van creados en domino es decir sin evento, no se puede crear controlador y sin controlador el componente, y que necesitamos para crear este evento pues necesitaremos crear una clase que a poder ser se llama EventoCambiaColor y que herede de evento y luego necesitamos las variables de controlador de versiones que es el variable estatica de tipo long que lo llamaremos serialVersion y le pondremos de valor 1L, la siguiente variable sera publica y estatica y este sera el encargado de crear la variable evento que debe ser tipo EventType<Nombre_de_la_clase> y este de ser iniciado con un new EventType<>(Event.ANY, "Accion_que_realiza_el_Evento") y por ultimo una variable Paint que deberiamos llamarla pintura o algo distintivo.

Luego crearemos un constructor que nos pedira de entrada una variable de pintura, luego debemos usar el super ya que recordemos estamos heradando de Event y luego de eso actualizaremos nuestra variable de pintura con la que recibimos de fuera. Una vez echo el constructor lo que haremos sera un getPintura para en algun caso acceder a la variable pintura ya que esta variable es privada.


-Lo segundo que debemos crear es nuestro controlador que puede tener cualquier nombre pero lo recomendable es poner controlador mas el nombre de componente que vamos crear, y que va contener nuestro controlador pues debe tener todos los elementos de nuestro componente en nuestro caso seria un atributo circulo, un grupo de radio button, los radio butom que seran con los que mas adelante podremos cambiar el color. 

Lo siguiente que haremos sera crear el eventos que lo unico que contiene es un cambio de color segun el radio button y una pintura que contiene el color que cambiaremos y como sabemos si esta pulsado o no pues es muy sencillo con la accion isSelected esta se usa como bandera y si esta selecionada pues la pintura debe cambiar al color que nosotros le indiquemos con la sentencia Nombre_variable_pintura = Paint.valueOf("color en hexadecimal") eso lo repetimos con todos los radio button que tengamos. Para que nuestro componente circulo pueda cambiar debemos finalirzar el evento con las sentecias nombre_variable_circulo.setFill(pintura) que esta nos actualizara el color del circulo y por ultimo necesitamos lanzar el evento y eso lo haremos con la sentencia nombre_variable_circulo.fireEvent(new EventoCambioColor(nombre_variable_pintura)) usamos la clase evento que creamos antes.


-Por ultimo la clase componente debe tener ser heredada de un Pane o Vbox esto depende de lo que usemos en el XML, la primera y unica varible necesaria en esta clase sera de la clase controlador previamente creada que la nombraremos controlador y luego crearemos un constructor que nos permitra cargar los eventos del XML que nosostros hemos implementado en el XML con la variable FMXLLoader, esta la usaremos con las siguiente sentencias:
    "loader.setRoot(this);
		 loader.setController(this.controlador);
		 loader.setLocation(getClass().getResource("/Carpeta_principal_del_proyecto_en_la_carpeta_java/carpeta_donde_se_guarda_el_componente/Nombre_del_XLM.fxml"));
		 loader.load();"
Todo esto lo debemos tener metido en try catch ya que puede darnos una excepción que la trataremos en el catch con la sentencia nombre_del_parametro_de_la_excepción.printStackTrace(). Y con eso tendriamos todo creado y funcionaria nuestro componente. 
