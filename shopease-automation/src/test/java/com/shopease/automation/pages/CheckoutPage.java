
package com.shopease.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
public class CheckoutPage extends BasePage {

    // Saved addresses container
    @FindBy(xpath = "//div[contains(@id,'savedAddresses')]")
    private WebElement savedAddresses;

    // Coupon code input
    @FindBy(id = "couponCode")
    private WebElement couponCodeInput;

    // Apply coupon button
    @FindBy(id = "applyCouponButton")
    private WebElement applyCouponButton;

    // Place order button
    @FindBy(id = "placeOrderButton")
    private WebElement placeOrderButton;

    @FindBy(id = "paymentMethod")
    private WebElement paymentMethodDropdown;
    
    // Constructor
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    // Verify saved addresses are displayed
    public boolean areSavedAddressesDisplayed() {
        return wait.waitForVisibility(
            By.id("savedAddresses")
        ).isDisplayed();
    }

    // Select a saved address by its radio button value
    public void selectSavedAddress(String addressId) {
        By addressLocator = By.xpath(
            "//div[@id='savedAddresses']//input[@value='"
            + addressId + "']"
        );

        wait.waitForClickability(addressLocator).click();
    }

    // Enter coupon code
    public void enterCouponCode(String couponCode) {
        wait.waitForVisibility(
            By.id("couponCode")
        ).clear();

        couponCodeInput.sendKeys(couponCode);
    }

    // Apply coupon
    public void applyCoupon() {
        wait.waitForClickability(
            By.id("applyCouponButton")
        ).click();
    }
    
    
 // Select payment method by visible text
    public void selectPaymentMethod(String paymentMethod) {

        wait.waitForVisibility(By.id("paymentMethod"));

        Select paymentSelect = new Select(paymentMethodDropdown);

        paymentSelect.selectByVisibleText(paymentMethod);
    }

    // Place order
    public void placeOrder() {
        wait.waitForClickability(
            By.id("placeOrderButton")
        ).click();
    }
}
