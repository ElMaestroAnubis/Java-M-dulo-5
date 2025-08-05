package com.devsenior.clase1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Anotación: indica que esta clase es un controlador REST..que devuelve datos de forma directa
public class MensajeController {
    // Aquí puedes definir métodos que manejen las solicitudes HTTP
    // Por ejemplo, un método que devuelva un mensaje simple

    @GetMapping("/mensaje")
    public String obtenerMensaje() {
        return """
                <h1>¡Hola, Dev Senior!</h1>
                <p>Este es un mensaje de bienvenida desde el controlador MensajeController.</p>
                """;
    }

    @GetMapping("/persona")
    public Persona obtenerPersona() {
        return new Persona("Juan", 30);
    }
}
