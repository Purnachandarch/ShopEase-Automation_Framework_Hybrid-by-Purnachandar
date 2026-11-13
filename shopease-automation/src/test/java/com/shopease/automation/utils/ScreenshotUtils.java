
package com.shopease.automation.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

	public static String captureScreenshot(WebDriver driver, String testName) {

		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		
		
		String fileName = testName + "_" + timestamp + ".png";

		Path folder = Paths.get("test-output", "screenshots");
		
		try {
			Files.createDirectories(folder);
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Path destination = folder.resolve(fileName);
			
			
			Files.copy(source.toPath(), destination);

			return destination.toString();

		} catch (IOException e) {
			throw new RuntimeException("Unable to capture screenshot", e);
		}
	}
}
