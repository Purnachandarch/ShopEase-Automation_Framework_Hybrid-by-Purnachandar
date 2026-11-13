
package com.shopease.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddressPage extends BasePage {

    @FindBy(id = "fullName")
    private WebElement fullNameField;

    @FindBy(id = "phone")
    private WebElement phoneField;

    @FindBy(id = "addressLine")
    private WebElement addressField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "state")
    private WebElement stateField;

    @FindBy(id = "pincode")
    private WebElement pincodeField;

    @FindBy(id = "addressType")
    private WebElement addressTypeDropdown;

    @FindBy(id = "defaultAddress")
    private WebElement defaultAddressCheckbox;
    
    @FindBy(id = "saveButton")
    private WebElement saveAddressButton;

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    public void enterFullName(String name) {
        fullNameField.clear();
        fullNameField.sendKeys(name);
    }

    public void enterPhone(String phone) {
        phoneField.clear();
        phoneField.sendKeys(phone);
    }

    public void enterAddress(String address) {
        addressField.clear();
        addressField.sendKeys(address);
    }

    public void enterCity(String city) {
        cityField.clear();
        cityField.sendKeys(city);
    }

    public void enterState(String state) {
        stateField.clear();
        stateField.sendKeys(state);
    }

    public void enterPincode(String pincode) {
        pincodeField.clear();
        pincodeField.sendKeys(pincode);
    }

    public void selectAddressType(String type) {
        Select select = new Select(addressTypeDropdown);
        select.selectByVisibleText(type);
    }

    public void setAsDefaultAddress(boolean value) {
        if (defaultAddressCheckbox.isSelected() != value) {
            defaultAddressCheckbox.click();
        }
    }
    
    
    public void clickSaveAddress() {
        wait.waitForClickability(By.id("saveButton")).click();
    }
}
