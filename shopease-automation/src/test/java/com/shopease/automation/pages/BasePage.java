
package com.shopease.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.shopease.automation.utils.WaitUtils;

public class BasePage {

    protected WebDriver driver;
    protected WaitUtils wait;

    public BasePage(WebDriver driver) {

        this.driver = driver;
        wait = new WaitUtils(driver);
    } 

    // Navigate to a page
    public void navigateTo(String url) {
        driver.get(url);
    }

    // Get current page URL
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // Get page title
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Refresh current page
    public void refreshPage() {
        driver.navigate().refresh();
    }

    // Navigate back
    public void navigateBack() {
        driver.navigate().back();
    }

}
