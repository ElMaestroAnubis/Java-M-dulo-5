# Enunciado del Proyecto: Aerolínea - API REST con Spring Boot

El objetivo del proyecto es desarrollar una API REST en Spring Boot que permita gestionar el funcionamiento básico de una aerolínea. La aplicación estará organizada en una arquitectura por capas con Modelos, Repositorios (estructuras de datos en memoria), Servicios y Controladores, y deberá implementar operaciones CRUD junto con procesos de negocio específicos.

## Procesos a desarrollar en la API

### Gestión de Vuelos
- Crear vuelos con información básica: origen, destino, fecha y número de asientos disponibles.
- Consultar todos los vuelos disponibles.
- Eliminar vuelos existentes.

### Gestión de Pasajeros
- Registrar pasajeros con datos como nombre y documento de identidad.
- Consultar la lista de pasajeros.

### Gestión de Reservas
- Crear una reserva para un pasajero en un vuelo específico.
- Validar que el vuelo tenga asientos disponibles.
- Asignar automáticamente un asiento.
- Reducir la cantidad de asientos disponibles en el vuelo.
- Consultar todas las reservas realizadas.
- Cancelar una reserva existente:
  - Liberar el asiento reservado.
  - Incrementar nuevamente la disponibilidad de asientos en el vuelo.

## Reglas de negocio
- Un vuelo no puede aceptar más reservas de las que indiquen sus asientos disponibles.
- Una reserva siempre debe estar asociada tanto a un pasajero registrado como a un vuelo existente.
- La cancelación de reservas debe restaurar correctamente la disponibilidad de asientos.

## Estructura de la API
- **Modelos:** Vuelo, Pasajero, Reserva.
- **Repositorios:** listas en memoria para manejar vuelos, pasajeros y reservas.
- **Servicios:**
  - VueloService (gestión de vuelos).
  - ReservaService (gestión de reservas, validando disponibilidad y pasajero).
- **Controladores REST:**
  - VueloController → expone endpoints de vuelos.
  - ReservaController → expone endpoints de reservas.
  - (Opcional) PasajeroController → expone endpoints de pasajeros.
