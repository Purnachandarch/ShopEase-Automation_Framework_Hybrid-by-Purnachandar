
package com.shopease.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonUtils {

    // Clear and enter text
    public static void enterText(
            WebElement element, String text) {

        element.clear();
        element.sendKeys(text);
    }

    // Click an element
    public static void clickElement(WebElement element) {
        element.click();
    }

    // Get element text
    public static String getText(WebElement element) {
        return element.getText();
    }

    // Refresh browser
    public static void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    // Navigate back
    public static void navigateBack(WebDriver driver) {
        driver.navigate().back();
    }
}
