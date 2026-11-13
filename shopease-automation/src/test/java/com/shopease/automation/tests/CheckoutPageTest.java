package com.shopease.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.shopease.automation.base.BaseTest;
import com.shopease.automation.pages.LoginPage;
import com.shopease.automation.pages.HomePage;
import com.shopease.automation.pages.ProductDetailsPage;
import com.shopease.automation.utils.WaitUtils;
import com.shopease.automation.pages.CartPage;
import com.shopease.automation.pages.CheckoutPage;

public class CheckoutPageTest extends BaseTest {

	@Test
	public void verifyCheckoutPageNavigation() throws InterruptedException {

		driver.get("http://localhost:8080/login.html");
		WaitUtils util = new WaitUtils(driver);

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("Userthird@gmail.com", "Userthird@123");

		ProductDetailsPage productPage = new ProductDetailsPage(driver);

		productPage.addProductToCart("Apple 16 Pro");
		Thread.sleep(2000);
		util.alertAccept();

		HomePage homePage = new HomePage(driver);

		homePage.clickCart();

		CartPage cartPage = new CartPage(driver);
		cartPage.clickCheckout();

		CheckoutPage checkoutPage = new CheckoutPage(driver);

		Assert.assertTrue(checkoutPage.getCurrentUrl().contains("checkout"), "Checkout page navigation failed");

		Assert.assertTrue(checkoutPage.areSavedAddressesDisplayed(),
				"Saved addresses are not displayed on checkout page");

	}
}