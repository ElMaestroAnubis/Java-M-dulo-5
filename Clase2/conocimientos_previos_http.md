# Conocimientos previos: Verbos HTTP y su función en una API

Antes de trabajar con controladores en Spring Boot o cualquier otro
framework para desarrollar APIs, es fundamental entender los **verbos
HTTP** (también llamados **métodos HTTP**). Estos verbos definen la
**intención** de una petición que un cliente hace a un servidor, y
ayudan a mantener una comunicación clara y estandarizada entre ambos.

------------------------------------------------------------------------

## 1. GET

-   **Función:** Solicitar información del servidor.\
-   **Características:**
    -   No modifica datos en el servidor.
    -   Se usa para **leer o consultar** información.
    -   Puede llevar parámetros en la URL (query params o path
        variables).\
-   **Ejemplo práctico:**
    -   `GET /productos` → devuelve todos los productos.
    -   `GET /productos/1` → devuelve el producto con ID 1.

------------------------------------------------------------------------

## 2. POST

-   **Función:** Enviar datos al servidor para crear un nuevo recurso.\
-   **Características:**
    -   Generalmente se utiliza para **crear** información.
    -   Los datos se envían en el cuerpo de la petición (o como
        parámetros en casos simples).
    -   Puede generar un nuevo ID para el recurso creado.\
-   **Ejemplo práctico:**
    -   `POST /productos` con un cuerpo como:

        ``` json
        {
          "nombre": "Tablet",
          "precio": 1500
        }
        ```

        Esto crea un nuevo producto.

------------------------------------------------------------------------

## 3. PUT

-   **Función:** Actualizar por completo un recurso existente.\
-   **Características:**
    -   Se envía el recurso completo (no solo los campos que cambian).
    -   Reemplaza la representación anterior del recurso por la nueva.
    -   Si el recurso no existe, en algunos casos puede crearlo (depende
        de la implementación).\
-   **Ejemplo práctico:**
    -   `PUT /productos/1` con un cuerpo como:

        ``` json
        {
          "nombre": "Laptop Gamer",
          "precio": 3000
        }
        ```

        Esto reemplaza todos los datos del producto con ID 1.

------------------------------------------------------------------------

## 4. PATCH

-   **Función:** Actualizar parcialmente un recurso existente.\
-   **Características:**
    -   A diferencia de PUT, **solo envía los campos que cambian**.
    -   Es más eficiente cuando no es necesario reemplazar todo el
        recurso.\
-   **Ejemplo práctico:**
    -   `PATCH /productos/1` con un cuerpo como:

        ``` json
        {
          "precio": 2800
        }
        ```

        Solo actualiza el precio del producto con ID 1.

------------------------------------------------------------------------

## 5. DELETE

-   **Función:** Eliminar un recurso del servidor.\
-   **Características:**
    -   No devuelve datos del recurso eliminado (aunque puede enviar un
        mensaje de confirmación).
    -   Se considera una operación **destructiva**.\
-   **Ejemplo práctico:**
    -   `DELETE /productos/1` → elimina el producto con ID 1.

------------------------------------------------------------------------

## Importancia de estos verbos en el desarrollo de APIs

-   Permiten diseñar **APIs RESTful** claras y fáciles de usar.
-   Hacen que la comunicación entre cliente y servidor sea más
    **predecible y estandarizada**.
-   Facilitan el mantenimiento y la comprensión del sistema.
