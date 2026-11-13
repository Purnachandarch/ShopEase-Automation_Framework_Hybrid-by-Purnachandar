
package com.shopease.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import com.shopease.automation.utils.CommonUtils;

public class HomePage extends BasePage {

	// Search input
	@FindBy(id = "searchInput")
	private WebElement searchInput;

	// Cart link
	@FindBy(xpath = "//a[contains(text(),'Cart')]")
	private WebElement cartLink;

	// Logout button
	@FindBy(id = "logoutBtn")
	private WebElement logoutButton;

	// Constructor
	public HomePage(WebDriver driver) {
		super(driver);
		
	}

	

	// Search product
	public void searchProduct(String productName) {
		CommonUtils.enterText(searchInput, productName);
	}

	// Open cart
	public void clickCart() {
		By locator = By.xpath("//a[contains(text(),'Cart')]");

		wait.scrollToElement(locator).click();

		//wait.waitForClickability(By.xpath("//a[contains(text(),'Cart')]")).click();

	}

	// Logout
	public void logout() {
		wait.waitForClickability(By.id("logoutBtn")).click();
	}

	// Verify logout button visibility
	public boolean isLogoutButtonDisplayed() {
		return logoutButton.isDisplayed();
	}
}
