package com.shopease.automation.tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.shopease.automation.base.BaseTest;
import com.shopease.automation.pages.LoginPage;
import com.shopease.automation.pages.HomePage;
import com.shopease.automation.pages.CartPage;

public class CartPageTest extends BaseTest {

	@Test
	public void verifyCartPageNavigation() {

		driver.get("http://localhost:8080/login.html");

		LoginPage loginPage = new LoginPage(driver);

		loginPage.login("Userthird@gmail.com", "Userthird@123");

		HomePage homePage = new HomePage(driver);
		homePage.clickCart();

		Assert.assertTrue(driver.getCurrentUrl().contains("cart"), "Cart page navigation failed");

		CartPage cartpage = new CartPage(driver);

		Assert.assertTrue(cartpage.isProductDisplayed("Samsung Galaxy M35"), "Product is not displayed in the cart");

		cartpage.updateProductQuantity("Samsung Galaxy M35", 1);
		driver.switchTo().alert().accept();

		Assert.assertTrue(cartpage.isProductDisplayed("Samsung Galaxy M35"),
				"Product disappeared after quantity update");
		cartpage.removeProduct("Samsung Galaxy M35");
		driver.switchTo().alert().accept();

//		Assert.assertFalse(cartpage.isProductDisplayed("Samsung Galaxy M35"), "Product was not removed from the cart");
	}

	@Test
	public void verifyCartGrandTotal() {
		driver.get("http://localhost:8080/login.html");

		LoginPage loginPage = new LoginPage(driver);

		loginPage.login("Userthird@gmail.com", "Userthird@123");

		HomePage homePage = new HomePage(driver);
		homePage.clickCart();

		CartPage cartPage = new CartPage(driver);

		double total = cartPage.getGrandTotal();

		Assert.assertTrue(total > 0, "Cart Grand Total should be greater than zero");

		System.out.println("Cart Grand Total: ₹" + total);
	}
}
