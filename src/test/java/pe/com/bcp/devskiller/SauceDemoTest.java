package pe.com.bcp.devskiller;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebElement;
import pe.com.bcp.devskiller.base.BaseTest;
import pe.com.bcp.devskiller.driver.DriverManager;
import pe.com.bcp.devskiller.page.HomePage;
import pe.com.bcp.devskiller.page.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SerenityJUnit5Extension.class)
public class SauceDemoTest extends BaseTest {

    @Steps
    private LoginPage loginPage;
    @Steps
    private HomePage homePage;

    @Test
    public void validarUrlCorrecta() {
        final String EXPECTED_URL_LOGIN = "https://www.saucedemo.com/";
        loginPage.open();
        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        assertEquals(EXPECTED_URL_LOGIN, currentUrl, "La URL enviada no es >>> " + EXPECTED_URL_LOGIN);
    }

    @Test
    public void validarLoginOK() {
        final String EXPECTED_URL_HOME = "https://www.saucedemo.com/inventory.html";
        loginPage.open();
        WebElement userInput = loginPage.userInput();
        assertNotNull(userInput, "Username input element is null");
        userInput.sendKeys("standard_user");

        WebElement passwordInput = loginPage.passwordInput();
        assertNotNull(passwordInput, "Password input element is null");
        passwordInput.sendKeys("secret_sauce");

        WebElement loginButton = loginPage.loginButton();
        assertNotNull(loginButton, "Login button element is null");
        loginButton.click();

        assertEquals(EXPECTED_URL_HOME, homePage.getHomeUrl());
    }

    @Test
    public void validarErrorUsuarioBloqueado() {
        final String EXPECTED_ERROR_MESSAGE = "Epic sadface: Sorry, this user has been locked out.";
        loginPage.open();
        WebElement userInput = loginPage.userInput();
        assertNotNull(userInput, "Username input element is null");
        userInput.sendKeys("locked_out_user");

        WebElement passwordInput = loginPage.passwordInput();
        assertNotNull(passwordInput, "Password input element is null");
        passwordInput.sendKeys("secret_sauce");

        WebElement loginButton = loginPage.loginButton();
        assertNotNull(loginButton, "Login button element is null");
        loginButton.click();

        WebElement errorMessage = loginPage.errorMessage();
        assertNotNull(errorMessage, "Error message element is null");
        assertEquals(EXPECTED_ERROR_MESSAGE, errorMessage.getText());
    }
}