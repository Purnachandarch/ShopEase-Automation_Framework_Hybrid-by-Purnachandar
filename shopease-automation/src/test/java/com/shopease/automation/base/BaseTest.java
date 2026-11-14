
package com.shopease.automation.base;

import org.openqa.selenium.WebDriver;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.ITestResult;

import com.shopease.automation.utils.ScreenshotUtils;
import com.shopease.automation.utils.ConfigReader;
import com.shopease.automation.utils.ExtentReportManager;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import com.shopease.automation.utils.FailureScreenshotStore;


public class BaseTest {

	protected WebDriver driver;
	@BeforeClass
	public void initializeExtentReport() throws IOException {

	    ExtentReportManager.initialize(
	        this.getClass().getSimpleName()
	    );

	    System.out.println(
	        "EXTENT REPORT INITIALIZED FOR: "
	        + this.getClass().getSimpleName()
	    );
	}
	@AfterClass
	public void flushExtentReport() {

	    ExtentReportManager.getInstance().flush();

	    System.out.println("EXTENT REPORT GENERATED SUCCESSFULLY");
	}
	@BeforeMethod
	public void setUp() {

		driver = DriverFactory.initializeDriver();

		String baseUrl = ConfigReader.getProperty("baseUrl");

		driver.get(baseUrl);
	}

	@AfterMethod
	public void captureScreenshotOnFailure(ITestResult result) {

	    if (result.getStatus() == ITestResult.FAILURE
	            && Boolean.parseBoolean(
	                    ConfigReader.getProperty("screenshotOnFailure"))) {

	        byte[] screenshot = ((TakesScreenshot) driver)
	                .getScreenshotAs(OutputType.BYTES);

	        FailureScreenshotStore.setScreenshot(screenshot);

	        ScreenshotUtils.captureScreenshot(driver, result.getName());
	    }
	}

	@AfterMethod(dependsOnMethods = "captureScreenshotOnFailure")
	public void tearDown() {

		DriverFactory.quitDriver();
	}
}
