# Introducción a las Anotaciones en Spring Boot

En **Spring Boot**, las **anotaciones** son fragmentos de metadatos que indican a Spring cómo debe comportarse una clase, método o variable.  
Gracias a ellas, se puede reducir drásticamente la configuración manual, reemplazando la antigua necesidad de configurar archivos XML extensos y difíciles de mantener.  

Las anotaciones permiten a Spring **entender la intención del desarrollador** y realizar automáticamente tareas como:
- Crear y administrar objetos (beans) en su contenedor de inversión de control (**IoC**).
- Configurar rutas HTTP y controladores REST.
- Manejar inyección de dependencias sin código repetitivo.
- Facilitar el manejo de excepciones y la traducción de errores específicos.

Ejemplo rápido de comparación:

**Antes (XML):**
```xml
<bean id="materialService" class="com.ejemplo.service.MaterialServiceImpl" />
```

**Ahora (Java con anotaciones):**
```java
@Service
public class MaterialServiceImpl implements MaterialService {
    // Lógica de negocio
}
```

---

## Anotaciones usadas en el proyecto de **Control de Material en Bodega**

### `@RestController`
Indica que una clase es un **Controlador REST** que puede recibir peticiones HTTP y devolver respuestas (generalmente en JSON).  
Esta anotación combina el comportamiento de:
- `@Controller` → Marca la clase como un controlador.
- `@ResponseBody` → Indica que el resultado de los métodos se enviará directamente como respuesta HTTP.

**Ejemplo:**
```java
@RestController
@RequestMapping("/materiales")
public class MaterialController {

    @GetMapping
    public List<Material> listarMateriales() {
        return List.of(new Material("Cemento", 50), new Material("Arena", 100));
    }
}
```
 **Uso en el proyecto:** Se aplica a clases que manejan las operaciones de consulta, registro, edición y eliminación de materiales.

---

### `@RequestMapping` y derivados (`@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`)
Definen las rutas HTTP y el tipo de petición que manejará un método o clase.  
- `@RequestMapping` es genérica (sirve para cualquier método HTTP).
- Las anotaciones derivadas son más específicas y claras.

**Ejemplo:**
```java
@RestController
@RequestMapping("/materiales")
public class MaterialController {

    @PostMapping
    public String registrarMaterial(@RequestBody Material material) {
        return "Material " + material.getNombre() + " registrado con éxito";
    }
}
```
 **Uso en el proyecto:** Para vincular cada acción (registrar, listar, actualizar, eliminar) con un endpoint HTTP específico.

---

### `@Service`
Marca una clase como parte de la **capa de servicio**, donde reside la lógica de negocio.  
Spring la detecta y la gestiona como un bean, permitiendo su inyección en controladores u otros servicios.

**Ejemplo:**
```java
@Service
public class MaterialServiceImpl implements MaterialService {

    @Override
    public boolean verificarStock(Material material) {
        return material.getCantidad() > 0;
    }
}
```
 **Uso en el proyecto:** Validar reglas como "no se puede despachar material si no hay stock suficiente".

---

### `@Repository`
Identifica una clase como responsable del acceso a datos (base de datos real o simulada).  
Además de ser un bean, esta anotación hace que Spring traduzca automáticamente las excepciones específicas de la base de datos a excepciones estándar de Spring.

**Ejemplo:**
```java
@Repository
public class MaterialRepositorySimulado {

    private final List<Material> inventario = new ArrayList<>();

    public void guardar(Material material) {
        inventario.add(material);
    }
}
```
 **Uso en el proyecto:** Simular el almacenamiento y recuperación de datos sin necesidad de una base de datos real.

---

### `@Autowired`
Indica a Spring que debe **inyectar** una dependencia automáticamente en el punto donde se utiliza, ya sea:
- En atributos.
- En el constructor.
- En métodos setter.

**Ejemplo:**
```java
@RestController
@RequestMapping("/materiales")
public class MaterialController {

    private final MaterialService materialService;

    @Autowired
    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }
}
```
 **Uso en el proyecto:** Permite que el `MaterialController` utilice los métodos del `MaterialService` sin necesidad de instanciarlo manualmente.

---

# Service Layer (Capa de Servicio)

## ¿Qué es?
La **Service Layer** es la capa de la aplicación donde vive la **lógica de negocio**.  
Es el puente entre:
- Los **controladores**, que reciben peticiones del usuario.
- La **capa de datos**, que interactúa con la base de datos o almacenamiento.

En esta capa:
- Se aplican reglas de negocio.
- Se coordinan llamadas a repositorios.
- Se preparan datos para enviarlos de vuelta al controlador.

---

## ¿Por qué usarla?

1. **Separación de responsabilidades**  
   El controlador maneja la entrada/salida de datos y delega las reglas a los servicios.

2. **Reutilización de código**  
   Un servicio puede ser utilizado por múltiples controladores o incluso por otros servicios.

3. **Mantenimiento más fácil**  
   Modificar la lógica de negocio no afecta directamente al controlador ni a la base de datos.

4. **Testeo independiente**  
   Los servicios se pueden probar sin necesidad de iniciar el servidor o conectarse a la base de datos.

---

## Ejemplo de flujo usando Service Layer

```
Cliente → Controlador (REST) → Servicio (reglas de negocio) → Repositorio (datos)
```

**Código:**
```java
@Service
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepositorySimulado repository;

    @Autowired
    public MaterialServiceImpl(MaterialRepositorySimulado repository) {
        this.repository = repository;
    }

    @Override
    public boolean registrarMaterial(Material material) {
        if (material.getCantidad() <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        repository.guardar(material);
        return true;
    }
}
```

---

# Estructura típica en un proyecto Spring Boot con Service Layer

```
src/main/java/com/ejemplo/proyecto/
│
├── controller/         ← Controladores REST (manejan peticiones HTTP)
│   └── MaterialController.java
│
├── service/            ← Servicios y lógica de negocio
│   ├── MaterialService.java      ← Interfaz
│   └── MaterialServiceImpl.java  ← Implementación
│
├── repository/         ← Acceso a datos
│   └── MaterialRepositorySimulado.java
│
├── model/              ← Entidades o modelos de datos
│   └── Material.java
│
└── Application.java    ← Clase principal que arranca la aplicación
```
