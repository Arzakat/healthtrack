package com.healthtrack;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        SimpleServer.start();

        try (Scanner scanner = new Scanner(System.in)) {
        
            System.out.println("Healthtrack APP");
            
            // 1. Registrar usuario
            System.out.print("Ingrese su nombre: ");
            String nombre = scanner.nextLine();
            
            System.out.print("Ingrese su peso actual en kg: ");
            double peso = scanner.nextDouble();
            
            Usuario usuario = new Usuario(nombre, peso);
            System.out.println("\n" + usuario.getInfo());
            
            // 2. Menú de opciones
            int opcion;
            do {
                System.out.println("\n1. Actualizar peso");
                System.out.println("2. Ver mi información");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");
                
                opcion = scanner.nextInt();
                
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese nuevo peso (kg): ");
                        double nuevoPeso = scanner.nextDouble();
                        try {
                            usuario.actualizarPeso(nuevoPeso);
                            System.out.println("Peso actualizado correctamente");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case 2:
                        System.out.println("\n" + usuario.getInfo());
                        break;
                }
            } while (opcion != 3);
            
            System.out.println("Gracias por usar Healthtrack!");
        }
    }
}