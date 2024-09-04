package pe.com.bcp.devskiller.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pe.com.bcp.devskiller.driver.DriverManager;

public class HomePage {

    private final By someElement = By.id("some-element-id"); // Replace with actual locator

    public String getHomeUrl() {
        return DriverManager.getDriver().getCurrentUrl();
    }

    public WebElement someElement() {
        return DriverManager.getDriver().findElement(someElement);
    }
}