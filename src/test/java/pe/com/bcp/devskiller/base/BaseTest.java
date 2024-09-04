package pe.com.bcp.devskiller.base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import pe.com.bcp.devskiller.driver.DriverManager;

public abstract class BaseTest {

    @BeforeAll
    public static void setUp() {
        HtmlUnitDriver driver = new HtmlUnitDriver();
        DriverManager.setDriver(driver);
    }

    @AfterAll
    public static void tearDown() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
        }
    }
}