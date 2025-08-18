# Principios SOLID y su Aplicación Práctica en Java

## ¿Qué son los Principios SOLID y Por Qué Son Importantes?

SOLID es un acrónimo que representa cinco principios fundamentales para el diseño de software:

1. **S** - Single Responsibility Principle (Principio de Responsabilidad Única)
2. **O** - Open/Closed Principle (Principio Abierto/Cerrado)
3. **L** - Liskov Substitution Principle (Principio de Sustitución de Liskov)
4. **I** - Interface Segregation Principle (Principio de Segregación de Interfaz)
5. **D** - Dependency Inversion Principle (Principio de Inversión de Dependencia)

Seguir estos principios ayuda a construir software con las siguientes cualidades:

- **Mantenible:** Más fácil de corregir y actualizar.
- **Escalable:** Permite añadir nuevas características con menos esfuerzo.
- **Flexible:** Adaptable a cambios futuros.
- **Comprensible:** Diseño claro y fácil de entender.
- **Testable:** Facilita la escritura de pruebas unitarias.

## Principios SOLID en Detalle

### 1. Single Responsibility Principle (SRP)

**Definición:** Una clase debe tener **una, y solo una, razón para cambiar**. Esto significa que debe tener una única responsabilidad bien definida.

**Ejemplo de Violación:**

```java
public class BadReportGenerator {
    public String generateReportData() {
        // Generar datos del informe
        return "Datos del Informe";
    }

    public void saveToFile(String reportData, String filename) {
        // Guardar en archivo
    }

    public void sendEmail(String reportData, String emailAddress) {
        // Enviar por email
    }
}
```

**Refactorización:**

```java
public class ReportDataGenerator {
    public String generateReportData() {
        return "Datos del Informe";
    }
}

public class ReportSaver {
    public void saveToFile(String reportData, String filename) {
        // Guardar en archivo
    }
}

public class ReportEmailSender {
    public void sendEmail(String reportData, String emailAddress) {
        // Enviar por email
    }
}
```

### 2. Open/Closed Principle (OCP)

**Definición:** Las entidades de software deben estar **abiertas para extensión, pero cerradas para modificación**.

**Ejemplo de Violación:**

```java
public class BadAreaCalculator {
    public double calculateTotalArea(List<Object> shapes) {
        double totalArea = 0;
        for (Object shape : shapes) {
            if (shape instanceof Rectangle) {
                totalArea += ((Rectangle) shape).getArea();
            } else if (shape instanceof Circle) {
                totalArea += ((Circle) shape).getArea();
            }
        }
        return totalArea;
    }
}
```

**Refactorización:**

```java
public interface Shape {
    double calculateArea();
}

public class Rectangle implements Shape {
    @Override
    public double calculateArea() {
        return width * height;
    }
}

public class Circle implements Shape {
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

public class GoodAreaCalculator {
    public double calculateTotalArea(List<Shape> shapes) {
        return shapes.stream().mapToDouble(Shape::calculateArea).sum();
    }
}
```

### 3. Liskov Substitution Principle (LSP)

**Definición:** Las subclases deben ser sustituibles por sus clases base sin alterar el comportamiento esperado.

**Ejemplo de Violación:**

```java
public class Rectangle {
    public void setWidth(int width) { ... }
    public void setHeight(int height) { ... }
}

public class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }
}
```

**Solución:** Evitar herencia directa si no cumple el contrato esperado.

Usar una abstracción común (`Shape`)

En lugar de forzar herencia entre `Rectangle` y `Square`, se define una abstracción más general.

### Interfaz `Shape`

``` java
public interface Shape {
    double calculateArea();
}
```

### Implementación `Rectangle`

``` java
public class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    // getters y setters
    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }
    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }
}
```

### Implementación `Square`

``` java
public class Square implements Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

    // getter y setter
    public int getSide() { return side; }
    public void setSide(int side) { this.side = side; }
}
```

------------------------------------------------------------------------

## Ventaja

-   Tanto `Rectangle` como `Square` **implementan `Shape`**, pero **no
    se heredan entre sí**.\
-   Así, ambos cumplen el contrato de la abstracción `Shape` y se pueden
    sustituir sin alterar el comportamiento.

--------------------------------------------------


### 4. Interface Segregation Principle (ISP)

**Definición:** Los clientes no deben ser forzados a depender de interfaces que no usan.

**Ejemplo de Violación:**

```java
interface BadRobot {
    void run();
    void fly();
    void drill();
}
```

**Refactorización:**

```java
interface Movable {
    void run();
}

interface Flying {
    void fly();
}

interface Drilling {
    void drill();
}
```

### 5. Dependency Inversion Principle (DIP)

El principio dice:

1.  **Los módulos de alto nivel** (los que contienen lógica importante
    de negocio) **no deben depender de módulos de bajo nivel** (los que
    hacen tareas específicas como guardar en base de datos, enviar
    correos, etc.).\
2.  Ambos deben depender de una **abstracción** (interfaz o clase
    abstracta).

Esto evita que el código de negocio se "acople" a detalles técnicos, y
facilita cambiar implementaciones sin romper todo.

------------------------------------------------------------------------

## Ejemplo sin DIP (malo)

Imagina que tenemos un **sistema de notificaciones**.

``` java
public class EmailService {
    public void sendEmail(String message) {
        System.out.println("Enviando email: " + message);
    }
}

public class NotificationManager {
    private EmailService emailService = new EmailService();

    public void send(String message) {
        emailService.sendEmail(message);
    }
}
```

### ❌ Problema

-   `NotificationManager` (módulo de alto nivel) **depende
    directamente** de `EmailService` (detalle de bajo nivel).\
-   Si mañana quiero enviar WhatsApp o SMS, tengo que **modificar
    NotificationManager**.

------------------------------------------------------------------------

## Ejemplo aplicando DIP (bueno)

Creamos una **abstracción**:

``` java
public interface MessageService {
    void sendMessage(String message);
}
```

### Implementaciones de bajo nivel

``` java
public class EmailService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Enviando email: " + message);
    }
}

public class SmsService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Enviando SMS: " + message);
    }
}
```

### Módulo de alto nivel (independiente de detalles)

``` java
public class NotificationManager {
    private MessageService service;

    // Inyección de dependencia
    public NotificationManager(MessageService service) {
        this.service = service;
    }

    public void send(String message) {
        service.sendMessage(message);
    }
}
```

------------------------------------------------------------------------

## Uso del sistema

``` java
public class Main {
    public static void main(String[] args) {
        // Puedo elegir la implementación que quiera:
        MessageService email = new EmailService();
        NotificationManager notification1 = new NotificationManager(email);
        notification1.send("Hola por Email");

        MessageService sms = new SmsService();
        NotificationManager notification2 = new NotificationManager(sms);
        notification2.send("Hola por SMS");
    }
}
```

------------------------------------------------------------------------

## Ventaja

-   `NotificationManager` **no sabe** si el mensaje se envía por email,SMS, WhatsApp, etc.
-   Solo depende de la abstracción `MessageService`.
-   Esto hace el sistema **flexible, fácil de mantener y extensible**.

--------------------------------------------------

## Analogía simple

El DIP es como **usar un enchufe universal**.

-   Tu televisor (módulo de alto nivel) no debería depender de si la corriente es de pared, batería o panel solar (detalles de bajo nivel).
-   Ambos dependen de un **enchufe estándar (abstracción)** que conecta todo.
