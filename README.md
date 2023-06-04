# PRUEBA Servicio REST

En el directorio Brand encontramos el proyecto maven de la prueba. En el podemos encontrar un RestController con dos servicios (hacen lo mismo, solo varía la forma de enviar los parámetros) que devuelven un listado de PRICES para los parametros de entrada fecha de aplicación, identificador de producto, identificador de cadena:
  1. http://localhost:8080/brandRest/getpricesbody --> Los parámetros de entrada se deben enviar en el body.
  2. http://localhost:8080/brandRest/getprices/{idProducto}/{idBrand}/{DateLong} --> Los parámetros se envían en la url. La fecha debe ir en formato Long (en milisegundos).

Además, el proyecto incluye un par de test unitarios a ambos servicios en src/test/java.

El proyecto es un proyecto maven con Java 1.8 y para arrancarlo es suficiente con darle a "Run as..." -> "Spring Boot App". Cualquier duda o error al importar/arrancar el proyecto, por favor, indicarlo.

El archivo PRUEBAS.postman_collection.json contiene una colección de request a ambas urls. Para ello es necesario importar el archivo en el Postman (en caso de duda contactad conmigo por favor).
