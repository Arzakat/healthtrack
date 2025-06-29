package com.healthtrack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

    @Test
    public void testCreacionUsuario() {
        Usuario usuario = new Usuario("Ana", 65.5);
        assertEquals("Ana", usuario.getNombre());
        assertEquals(65.5, usuario.getPeso(), 0.001);
    }

    @Test
    public void testActualizarPesoValido() {
        Usuario usuario = new Usuario("Juan", 80.0);
        usuario.actualizarPeso(78.5);
        assertEquals(78.5, usuario.getPeso(), 0.001);
    }

    @Test
    public void testActualizarPesoNegativo() {
        Usuario usuario = new Usuario("Maria", 60.0);
        Exception exception = assertThrows(
            IllegalArgumentException.class,
            () -> usuario.actualizarPeso(-5.0)
        );
        assertEquals("El peso no puede ser negativo", exception.getMessage());
    }
    
    @Tag("regression")  // Mi prueba de regresión
    @Test
    public void testRegresionActualizacionPeso() {
        Usuario usuario = new Usuario("Test", 70.0);
        usuario.actualizarPeso(69.0);
        assertEquals(69.0, usuario.getPeso(), 0.001, "Error:La actualización de peso falló");
    }
}