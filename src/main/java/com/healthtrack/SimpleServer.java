package com.healthtrack;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.NetworkListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleServer {
    private static HttpServer server;

    public static void start() {
        server = new HttpServer();
        NetworkListener listener = new NetworkListener("grizzly", "0.0.0.0", 9090);
        
        try {
            server.addListener(listener);
            
            server.getServerConfiguration().addHttpHandler(
                new org.glassfish.grizzly.http.server.HttpHandler() {
                    @Override
                    public void service(org.glassfish.grizzly.http.server.Request request,
                                       org.glassfish.grizzly.http.server.Response response) throws Exception {
                        response.setContentType("application/json");
                        response.getWriter().write("{\"status\":\"alive\"}");
                    }
                }, "/api/peso");

            server.start();
            System.out.println("🔥 Servidor activo en http://localhost:9090/api/peso");
            System.out.println("👉 Presiona ENTER en esta consola para detenerlo...");

            // Espera entrada de usuario para apagar
            new BufferedReader(new InputStreamReader(System.in)).readLine();
            
        } catch (IOException e) {
            System.err.println("❌ Error: " + e.getMessage());
        } finally {
            stopServer(); // Asegura el cierre
        }
    }

    public static void stopServer() {
        if (server != null) {
            System.out.println("\n🛑 Deteniendo servidor...");
            server.shutdownNow();
            System.out.println("✅ Servidor detenido correctamente");
        }
    }

    public static void main(String[] args) {
        start();
    }
}