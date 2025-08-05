# Ejercicios de Controladores en Spring Boot

Estos ejercicios te ayudarán a practicar el uso de **@RestController** y
**@GetMapping** en Spring Boot. Cada ejercicio incluye una **pista**
para orientarte en la solución.

------------------------------------------------------------------------

## 1. Controlador que devuelve mensajes simples

**Objetivo:** Familiarizarse con `@RestController` y `@GetMapping`.

**Enunciado:** - Crea un controlador llamado `SaludoController`. -
Define un método que devuelva un mensaje en formato HTML cuando se
acceda a `/saludo`. - Define otro método que devuelva un mensaje en
texto plano cuando se acceda a `/saludo-texto`.

**Pista:** Utiliza `@RestController` y crea métodos que retornen
`String`.

------------------------------------------------------------------------

## 2. Devolver un objeto JSON

**Objetivo:** Aprender a devolver objetos serializados automáticamente
en formato JSON.

**Enunciado:** - Crea una clase `Producto` con atributos `nombre` y
`precio`. - Crea un controlador llamado `ProductoController`. - Define
un método que devuelva un objeto `Producto` en la ruta `/producto`.

**Pista:** Declara una clase simple con constructor, getters y setters.
Devuelve una instancia de esa clase en el método del controlador.

------------------------------------------------------------------------

## 3. Devolver una lista de objetos

**Objetivo:** Practicar el retorno de colecciones JSON.

**Enunciado:** - En el controlador `ProductoController`, crea un método
que devuelva una lista de varios productos en la ruta `/productos`.

**Pista:** Utiliza una lista (`List`) en el método y devuelve varias
instancias de `Producto`.

------------------------------------------------------------------------

## 4. Parámetros de consulta (`@RequestParam`)

**Objetivo:** Aprender a recibir datos desde la URL con parámetros.

**Enunciado:** - Crea un método en `ProductoController` que reciba
`nombre` y `precio` como parámetros. - Devuelve un objeto `Producto` con
esos datos.

**Pista:** Usa `@RequestParam` en los parámetros del método y devuelve
una nueva instancia de `Producto`.

------------------------------------------------------------------------

## 5. Combinar HTML y JSON

**Objetivo:** Devolver diferentes tipos de respuestas según la ruta.

**Enunciado:** - Crea un controlador `InfoController`. - Define una ruta
`/info-html` que devuelva un mensaje en HTML. - Define una ruta
`/info-json` que devuelva un objeto con información básica (ejemplo:
nombre del curso y versión).

**Pista:** Usa dos métodos diferentes dentro del mismo controlador: uno
que retorne `String` con contenido HTML y otro que retorne un objeto
simple.

------------------------------------------------------------------------
