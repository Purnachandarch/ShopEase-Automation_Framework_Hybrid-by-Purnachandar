
package com.shopease.automation.utils;

import java.time.Duration;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	private WebDriver driver;
	private WebDriverWait wait;

	public WaitUtils(WebDriver driver) {
		this.driver = driver;

		int timeout = Integer.parseInt(ConfigReader.getProperty("explicitWait"));

		wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	}

	public WebElement waitForVisibility(By locator) {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitForClickability(By locator) {

		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public boolean waitForUrlContains(String expectedUrl) {

		return wait.until(ExpectedConditions.urlContains(expectedUrl));
	}

	public boolean waitForInvisibility(By locator) {

		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public WebElement scrollToElement(By locator) {

		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		Actions actions = new Actions(driver);

		actions.scrollToElement(element).perform();

		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	
	public void alertAccept(){
		driver.switchTo().alert().accept();
	}
	public void alertDismiss(){
		driver.switchTo().alert().dismiss();
	}
	public String alertgetText(){
		 String alertText=driver.switchTo().alert().getText();
		 return alertText;
	}
	
	
}
