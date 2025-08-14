# Ejercicio: Gestión de Tickets de Soporte Técnico

## Enunciado
Una empresa de soporte técnico necesita un sistema básico para gestionar solicitudes de atención (**tickets**). El sistema debe permitir:

- Registrar nuevos tickets.
- Listar todos los tickets abiertos.
- Buscar un ticket por su identificador.
- Actualizar el estado de un ticket.
- Eliminar un ticket.

El desarrollo se realizará usando **arquitectura en capas** para reforzar el patrón **Service Layer** y facilitar la depuración del flujo entre **Controlador → Servicio → Modelo**.  
La capa de repositorio será simulada en memoria usando una lista o un mapa, ya que aún no se ha trabajado con bases de datos.

---

## Modelo Principal: Ticket
Campos requeridos:

- **id** (Long): Identificador único autogenerado.
- **titulo** (String): Breve descripción del problema.
- **descripcion** (String): Detalle del problema.
- **estado** (String): Puede ser `"ABIERTO"`, `"EN_PROCESO"` o `"CERRADO"`.
- **prioridad** (String): Puede ser `"BAJA"`, `"MEDIA"` o `"ALTA"`.
- **fechaCreacion** (LocalDateTime): Momento de creación.

---

## Operaciones Requeridas
1. **Crear un nuevo ticket**
   - Estado por defecto: `"ABIERTO"`.
   - Fecha de creación automática.

2. **Listar todos los tickets**.

3. **Buscar un ticket por ID**.

4. **Actualizar el estado de un ticket**
   - Solo aceptar valores válidos (`"ABIERTO"`, `"EN_PROCESO"`, `"CERRADO"`).

5. **Eliminar un ticket**.

---

## Flujo Esperado
1. El **Controlador** recibe la petición HTTP (POST, GET, PUT, DELETE).
2. El **Controlador** llama al **Servicio**, enviando los datos necesarios.
3. El **Servicio** aplica las reglas de negocio:
   - Generar ID único.
   - Validar estado.
   - Asignar fecha y estado inicial.
4. El **Servicio** llama al **Repositorio** simulado, que guarda o modifica el ticket en memoria.
5. El **Repositorio** devuelve la información al **Servicio**, y este al **Controlador**.

---

## Objetivos Pedagógicos
- Practicar la separación clara de responsabilidades por capas.
- Reforzar el concepto de **Service Layer** como encargado de la lógica de negocio.
- Ejercitar la depuración paso a paso, siguiendo un ticket desde el **Controlador** hasta el **Modelo**.
- Simular un flujo de datos real, aunque sin base de datos.

---

## Lógica en la Capa de Servicio
- Generar un **ID único** para cada ticket.
- Validar que el estado inicial sea `"ABIERTO"`.
- Asignar automáticamente la fecha de creación.
- Validar que los cambios de estado sean solo `"ABIERTO"`, `"EN_PROCESO"` o `"CERRADO"`.
