# README #

Pasos necesarios para la ejecucion de la aplicacion

### Acerca de V2.O.O ###

* El microservicio entrega un json de la raza, la subraza e imagenes de la raza.
* Recfactor donde se incorpora el uso de JsonObject para utilizar correctamente
* las excepciones asociadas a HttpMessageNotReadableException.
* Se realiza correcion de incidencias.
* Se optimizan las consultas al api para no realizar todas las llamadas a los 
* servicios en caso que la raza a consultar no se encuentre en la lista del api.