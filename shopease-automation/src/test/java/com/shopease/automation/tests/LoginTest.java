
package com.shopease.automation.tests;

import org.testng.Assert;
import com.shopease.automation.utils.RetryAnalyzer;

import org.testng.annotations.Test;

import com.shopease.automation.base.BaseTest;
import com.shopease.automation.pages.LoginPage;
import com.shopease.automation.utils.TestDataProvider;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LoginTest extends BaseTest {

	@Epic("ShopEase Application")
	@Feature("Customer Login")
	@Story("Valid Customer Login")
	@Description("Verify that a registered customer can log in successfully.")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void verifyValidCustomerLogin() throws InterruptedException {

		// Open login page
		driver.get("http://localhost:8080/login.html");

		// Initialize Login Page
		LoginPage loginPage = new LoginPage(driver);

		loginPage.login("Userthird@gmail.com", "Userthird@123");
		Thread.sleep(2000);

		String currentUrl = driver.getCurrentUrl();

		Assert.assertTrue(currentUrl.contains("index.html"), "Login failed or homepage redirect did not happen");

	}

	@Test(dataProvider = "loginData", dataProviderClass = TestDataProvider.class)
	public void verifyLoginWithMultipleData(String email, String password, boolean expectedResult) {

		driver.get("http://localhost:8080/login.html");

		LoginPage loginPage = new LoginPage(driver);

		loginPage.login(email, password);

		boolean actualResult = loginPage.isLoginSuccessful();

		Assert.assertEquals(actualResult, expectedResult, "Login result does not match expected result for: " + email);
	}

	@Test(dataProvider = "excelLoginData", dataProviderClass = TestDataProvider.class)
	public void verifyLoginUsingExcel(String email, String password, String expectedResult) {

		boolean expected = Boolean.parseBoolean(expectedResult);

		driver.get("http://localhost:8080/login.html");

		System.out.println(email + password + expectedResult);

		LoginPage loginPage = new LoginPage(driver);

		loginPage.login(email, password);

		boolean actualResult = loginPage.isLoginSuccessful();

		Assert.assertEquals(actualResult, expectedResult, "Login result does not match expected result for: " + email);
	}

	@Test(dataProvider = "jsonLoginData", dataProviderClass = TestDataProvider.class)
	public void verifyLoginUsingJson(String email, String password, String expectedResult) {

		boolean expected = Boolean.parseBoolean(expectedResult);

		driver.get("http://localhost:8080/login.html");

		System.out.println(email + password + expectedResult);

		LoginPage loginPage = new LoginPage(driver);

		loginPage.login(email, password);

		boolean actualResult = loginPage.isLoginSuccessful();

		Assert.assertEquals(actualResult, expectedResult, "Login result does not match expected result for: " + email);	}

}
