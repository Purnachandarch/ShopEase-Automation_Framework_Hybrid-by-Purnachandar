
package com.shopease.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage extends BasePage {

    // Constructor
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    // Dynamic XPath: Product price
    private By getProductPriceLocator(String productName) {
        return By.xpath(
            "//div[@class='card-body'][.//h5[contains(text(),'"
            + productName + "')]]//p[@class='price']"
        );
    }

    // Dynamic XPath: Add to Cart
    private By getAddToCartLocator(String productName) {
        return By.xpath(
            "//div[@class='card-body'][.//h5[contains(text(),'"
            + productName + "')]]//button[text()='Add to Cart']"
        );
    }

    // Dynamic XPath: Add to Wishlist
    private By getWishlistLocator(String productName) {
        return By.xpath(
            "//div[@class='card-body'][.//h5[contains(text(),'"
            + productName + "')]]//button[contains(text(),'Wishlist')]"
        );
    }

    // Get product price
    public String getProductPrice(String productName) {
        return wait.waitForVisibility(
            getProductPriceLocator(productName)
        ).getText();
    }

    // Add specific product to cart
    public void addProductToCart(String productName) {

        By locator = getAddToCartLocator(productName);

        wait.scrollToElement(locator).click();
    }

    // Add specific product to wishlist
    public void addProductToWishlist(String productName) {
        wait.waitForClickability(
            getWishlistLocator(productName)
        ).click();
    }
    public void checkAddToCartButton(String productName) {

        WebElement button = wait.waitForVisibility(
            getAddToCartLocator(productName)
        );

        System.out.println("Displayed: " + button.isDisplayed());
        System.out.println("Enabled: " + button.isEnabled());

        System.out.println(
            "Location: " + button.getLocation()
        );

        System.out.println(
            "Size: " + button.getSize()
        );
    }
    
}
