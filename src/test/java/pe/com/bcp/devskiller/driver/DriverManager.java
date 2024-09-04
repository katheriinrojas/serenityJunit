package pe.com.bcp.devskiller.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            synchronized (DriverManager.class) {
                if (driver == null) {
                    try {
                        // Configura la ruta del chromedriver
                        System.setProperty("webdriver.chrome.driver", "C:\\SerenityProjects\\BCP\\devskiller\\src\\test\\java\\pe\\com\\bcp\\devskiller\\chromeDriver\\chromedriver.exe");
                        driver = new ChromeDriver();
                    } catch (Exception e) {
                        e.printStackTrace(); // Maneja la excepción de manera adecuada
                    }
                }
            }
        }
        return driver;
    }

    public static void setDriver(WebDriver newDriver) {
        synchronized (DriverManager.class) {
            if (driver != null) {
                driver.quit(); // Cierra el WebDriver actual antes de asignar uno nuevo
            }
            driver = newDriver;
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            synchronized (DriverManager.class) {
                if (driver != null) {
                    driver.quit();
                    driver = null;
                }
            }
        }
    }
}