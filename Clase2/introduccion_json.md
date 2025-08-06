# Introducción a JSON: Conceptos y Ejemplos

JSON (**JavaScript Object Notation**) es un formato ligero para el
intercambio de datos. Es fácil de leer para los humanos y fácil de
interpretar para las máquinas.

------------------------------------------------------------------------

## 1. ¿Qué es JSON?

-   Es un formato basado en texto que permite representar datos
    estructurados.
-   Se utiliza comúnmente para **enviar datos entre un cliente y un
    servidor**.
-   Sus principales características:
    -   Basado en pares clave-valor.
    -   Permite listas (arreglos) y objetos anidados.
    -   Usa sintaxis similar a JavaScript, pero puede ser utilizado en
        cualquier lenguaje.

Ejemplo simple:

``` json
{
  "nombre": "Juan",
  "edad": 25
}
```

------------------------------------------------------------------------

## 2. Reglas básicas de JSON

1.  Las claves (keys) siempre van entre **comillas dobles**.
2.  Los valores pueden ser:
    -   Cadenas de texto (entre comillas dobles).
    -   Números (sin comillas).
    -   Booleanos (`true` o `false`).
    -   Arreglos (listas entre corchetes `[]`).
    -   Objetos (entre llaves `{}`).
    -   `null` para valores vacíos.
3.  No se permiten comentarios.

Ejemplo con diferentes tipos de valores:

``` json
{
  "nombre": "Ana",
  "edad": 30,
  "activo": true,
  "hobbies": ["leer", "correr", "cocinar"],
  "direccion": {
    "ciudad": "Bogotá",
    "pais": "Colombia"
  },
  "codigoPostal": null
}
```

------------------------------------------------------------------------

## 3. Arreglos en JSON

Los arreglos se usan para representar listas ordenadas.

Ejemplo:

``` json
{
  "estudiantes": [
    {"nombre": "Carlos", "edad": 20},
    {"nombre": "María", "edad": 22},
    {"nombre": "Pedro", "edad": 19}
  ]
}
```

------------------------------------------------------------------------

## 4. Objetos anidados

Los objetos anidados permiten estructurar datos más complejos.

Ejemplo:

``` json
{
  "empresa": "Tech Solutions",
  "empleados": [
    {
      "nombre": "Laura",
      "cargo": "Desarrolladora",
      "contacto": {
        "email": "laura@tech.com",
        "telefono": "123456789"
      }
    },
    {
      "nombre": "Luis",
      "cargo": "Analista",
      "contacto": {
        "email": "luis@tech.com",
        "telefono": "987654321"
      }
    }
  ]
}
```

------------------------------------------------------------------------

## 5. Buenas prácticas

-   Usar nombres de claves claros y significativos.
-   Mantener una estructura ordenada y consistente.
-   Evitar datos innecesarios para reducir el tamaño del archivo.
-   Validar el JSON para asegurarse de que es correcto (se puede usar
    <https://jsonlint.com/>).

------------------------------------------------------------------------

## 6. Ejercicio propuesto

1.  Crea un JSON que represente una **biblioteca** con:
    -   Nombre de la biblioteca.
    -   Una lista de libros, cada uno con título, autor y año.
    -   Datos del encargado de la biblioteca (nombre y contacto).
2.  Valida tu JSON en una herramienta online.

------------------------------------------------------------------------

**Conclusión:** JSON es fundamental para trabajar con APIs y
aplicaciones modernas, porque permite comunicar datos de forma
estandarizada y eficiente.
