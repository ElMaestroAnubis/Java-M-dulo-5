# Proyecto: Sistema de Gestión de Películas

## Enunciado

Se requiere desarrollar una aplicación básica en **Spring Boot** que permita gestionar un catálogo de películas.  
El sistema debe contar con una estructura organizada por capas (modelo, repositorio, servicio y controlador) y cumplir con las siguientes funcionalidades:

### Requisitos funcionales

1. **Listar todas las películas registradas** en el sistema.
2. **Agregar una nueva película**, especificando su nombre y categoría.
3. **Buscar una película por su ID** y mostrar sus detalles.
4. **Buscar películas por categoría**, devolviendo todas las que correspondan.
5. **Actualizar la información de una película existente** (nombre o categoría).
6. **Eliminar una película por su ID**.

### Requisitos no funcionales

- La aplicación debe ejecutarse en `http://localhost:8080`.
- La persistencia de datos será simulada mediante listas en memoria (no se requiere base de datos real).
- El código debe estar separado en capas para facilitar la comprensión y mantenimiento.

### Entregables

- Código fuente organizado por paquetes (`model`, `repository`, `service`, `controller`).
- Controlador con endpoints REST que permitan realizar las operaciones descritas anteriormente.
- Documentación mínima con ejemplos de peticiones para probar los endpoints (usando Postman o navegador).

