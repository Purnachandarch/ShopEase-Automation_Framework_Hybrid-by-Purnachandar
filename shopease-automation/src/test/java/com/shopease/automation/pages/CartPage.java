
package com.shopease.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

	// Checkout button
	@FindBy(xpath = "//button[contains(text(),'Checkout')]")
	private WebElement checkoutButton;

	// Constructor
	public CartPage(WebDriver driver) {
		super(driver);
	}

	// Dynamic XPath: Quantity input for a specific product
	private By getQuantityLocator(String productName) {
		return By.xpath("//tr[td[contains(normalize-space(.),'" + productName + "')]]//td//input");
	}

	// Dynamic XPath: Update button for a specific product
	private By getUpdateLocator(String productName) {
		return By.xpath("//tr[td[contains(normalize-space(.),'" + productName + "')]]//td//button[text()='Update']");
	}

	// Dynamic XPath: Remove button for a specific product
	private By getRemoveLocator(String productName) {
		return By.xpath("//tr[td[contains(normalize-space(.),'" + productName + "')]]//td//button[text()='Remove']");
	}

	// Update product quantity
	public void updateProductQuantity(String productName, int quantity) {

		WebElement quantityField = wait.waitForVisibility(getQuantityLocator(productName));

		quantityField.clear();
		quantityField.sendKeys(String.valueOf(quantity));

		wait.scrollToElement(getUpdateLocator(productName));

		wait.waitForClickability(getUpdateLocator(productName)).click();
	}

	public void removeProduct(String productName) {

		By locator = getRemoveLocator(productName);

		wait.scrollToElement(locator);
		wait.waitForClickability(getRemoveLocator(productName)).click();
	}

	// Remove a specific product

	// Verify whether a specific product exists
	public boolean isProductDisplayed(String productName) {

		try {
			return wait.waitForVisibility(By.xpath("//tr[td[contains(normalize-space(.),'" + productName + "')]]"))
					.isDisplayed();

		} catch (Exception e) {
			return false;
		}
	}

	// Click Checkout
	public void clickCheckout() {

		By locator = By.xpath("//button[contains(text(),'Checkout')]");

		wait.scrollToElement(locator).click();
	}
	
	// Get Grand Total from cart
	public double getGrandTotal() {

	    WebElement totalElement =
	            wait.waitForVisibility(By.id("totalAmount"));

	    String totalText = totalElement.getText();

	    return Double.parseDouble(totalText);
	}
}
