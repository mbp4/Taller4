# Taller4
 
link al repositorio: https://github.com/mbp4/Taller4.git

En el ejercicio propuesto se nos solicita crear una serie de pantallas que incluyan una bienvenida, un listado, un sensor de movimiento y un widget.

## Bienvenida

Esta será la primera pantalla que el usuario vea al iniciar la aplicación y estará compuesto por: 

 -> Un TextView: este elemento tendrá un saludo el cual varía dependiendo de la hora, es decir, si es por la mañana el mensaje será de "Buenos días" o viceversa.

 -> Un Button: este botón redirige al usuario al fragmento donde se muestra un listado de tareas en este caso, o lo que el usuario quiera introducir ya que es solamente una lista sin especificaciones.

## Listado

Esta activity es la pantalla donde se mostrará un listado de elementos donde el usuario podrá introducir un titulo de elemento y una descripción. 

En este caso para que la lista no se muestre vacia tendrá siempre una por defecto. 

En caso de que se quiera visualizar el elemento de manera detallada se pulsara sobre el mismo y el fragmento cambiará a uno nuevo donde se mostrara: 

 -> Dos TextView: uno que muestre el título del elemento y otro que muestre la descripción. 

 -> Un Button: el boton permite al usuario volver al fragmento inicial. 

El listado tambien tiene un Button que te lleva a un sensor, este sensor es de tipo acelerometro, formado por: 

 -> Una imagen: que simule que es un viajero, para que el usuario lo use como si estuviera de ruta.

 -> Un Button: el botón permite al usuario volver a la actividad anterior.

En esta activity en caso de que el usuairo haga algun movimiento en el teléfono, el sensor lo detecta y cambiará el fondo para que el usuario sepa que esta en movimiento.

## Widget: 

Esta activity se encarga de mostrar el listado de elementos mediante un widget, este tendrá un Button que se encargará de actualizar el mismo en caso de que el usuairo lo desee. 
