package com.healthtrack;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HealthTrackFunctionalTest {
    private WebDriver driver;
    private static final String APP_URL = "http://localhost:9090"; // Me funciona acá con: python -m http.server 9090

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Usuario Nuevo/devops/healthtrack/src/test/java/com/healthtrack/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testRegistroYActualizacionPeso() {
        // ingresa a la pag
        driver.get(APP_URL);
        
        // registrar usuario
        driver.findElement(By.id("nombre")).sendKeys("TestUser");
        driver.findElement(By.id("peso")).sendKeys("70.5");
        driver.findElement(By.id("registrar-btn")).click();
        
        // actualiza peso
        driver.findElement(By.id("nuevo-peso")).sendKeys("69.0");
        driver.findElement(By.id("actualizar-btn")).click();
        
        // veridica
        WebElement mensaje = driver.findElement(By.id("mensaje-peso"));
        assertTrue(mensaje.getText().contains("69.0 kg"));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}