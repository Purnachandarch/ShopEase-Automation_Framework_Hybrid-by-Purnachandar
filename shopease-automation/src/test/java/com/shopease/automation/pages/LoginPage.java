
package com.shopease.automation.pages;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.shopease.automation.utils.CommonUtils;

public class LoginPage extends BasePage {

    // Email field
    @FindBy(id = "email")
    private WebElement emailField;

    // Password field
    @FindBy(id = "password")
    private WebElement passwordField;

    // Login button
    @FindBy(id = "loginButton")
    private WebElement loginButton;

    // Error message
    @FindBy(id = "message")
    private WebElement errorMessage;

    // Register link
    @FindBy(xpath = "//a[contains(text(),'Register')]")
    private WebElement registerLink;

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
        }

    // Page actions
    @Step("Enter customer email")
    public void enterEmail(String email) {
        CommonUtils.enterText(emailField, email);
    }
    @Step("Enter customer password")
    public void enterPassword(String password) {
        CommonUtils.enterText(passwordField, password);
    }
    @Step("Click Login button")
    public void clickLogin() {
        wait.waitForClickability(
            org.openqa.selenium.By.id("loginButton")
        ).click();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }
    
    @Step("Verify customer login result")
    public boolean isLoginSuccessful() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains("index.html"),
                ExpectedConditions.visibilityOfElementLocated(
                        org.openqa.selenium.By.id("message")
                )
        ));

        return driver.getCurrentUrl().contains("index.html");
    }
}
