
package com.shopease.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.shopease.automation.utils.ConfigReader;

public class DriverFactory {

	private static WebDriver driver;

	public static WebDriver initializeDriver() {

		String browser = ConfigReader.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();

		} else {

			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}

		driver.manage().window().maximize();

		return driver;
	}

//	public static WebDriver getDriver() {
//		return driver;
//	}

	public static void quitDriver() {

		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
