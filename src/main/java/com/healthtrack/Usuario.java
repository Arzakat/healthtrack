package com.healthtrack;

public class Usuario {
    private final String nombre;
    private double peso;

    public Usuario(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    // Getters
    public String getNombre() { return nombre; }
    public double getPeso() { return peso; }

    // Lógica corregida de actualización
    public void actualizarPeso(double nuevoPeso) {
        if (nuevoPeso < 0) {
            throw new IllegalArgumentException("El peso no puede ser negativo");
        }
        this.peso = nuevoPeso;
    }

    // Nuevo método para mostrar info
    public String getInfo() {
        return String.format("Usuario: %s | Peso: %.1f kg", nombre, peso);
    }
}