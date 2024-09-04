package pe.com.bcp.devskiller.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pe.com.bcp.devskiller.driver.DriverManager;

import java.time.Duration;

public class LoginPage {

    private final By username = By.xpath("//input[@role='textbox' and @id='user-name']");
    private final By password = By.xpath("//input[@role='textbox' and @id='password']");
    private final By loginButton = By.xpath("//input[@role='button' and @id='login-button']");
    private final By errorMessage = By.xpath("//h3[@data-test='error']");
    private WebDriverWait wait;

    public LoginPage() {
        this.wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
    }

    public void open() {
        DriverManager.getDriver().get("https://www.saucedemo.com/");
    }

    public WebElement userInput() {
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(username));
            if (element == null) {
                System.out.println("Username input element not found!");
            }
            return element;
        } catch (Exception e) {
            System.out.println("Current URL: " + DriverManager.getDriver().getCurrentUrl());
            System.out.println("Page Source: " + DriverManager.getDriver().getPageSource());
            e.printStackTrace();
            return null;
        }
    }

    public WebElement passwordInput() {
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(password));
            if (element == null) {
                System.out.println("Password input element not found!");
            }
            return element;
        } catch (Exception e) {
            System.out.println("Current URL: " + DriverManager.getDriver().getCurrentUrl());
            System.out.println("Page Source: " + DriverManager.getDriver().getPageSource());
            e.printStackTrace();
            return null;
        }
    }

    public WebElement loginButton() {
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(loginButton));
            if (element == null) {
                System.out.println("Login button element not found!");
            }
            return element;
        } catch (Exception e) {
            System.out.println("Current URL: " + DriverManager.getDriver().getCurrentUrl());
            System.out.println("Page Source: " + DriverManager.getDriver().getPageSource());
            e.printStackTrace();
            return null;
        }
    }

    public WebElement errorMessage(){
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage));
            if (element == null) {
                System.out.println("Error message element not found!");
            }
            return element;
        } catch (Exception e) {
            System.out.println("Current URL: " + DriverManager.getDriver().getCurrentUrl());
            System.out.println("Page Source: " + DriverManager.getDriver().getPageSource());
            e.printStackTrace();
            return null;
        }
    }
}