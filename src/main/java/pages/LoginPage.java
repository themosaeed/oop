package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //elements
    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");
    public By errorButton = By.className("error-button");


    //actions
    public void login(String username, String Password){
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(Password);
        driver.findElement(loginButton).click();
    }

}
