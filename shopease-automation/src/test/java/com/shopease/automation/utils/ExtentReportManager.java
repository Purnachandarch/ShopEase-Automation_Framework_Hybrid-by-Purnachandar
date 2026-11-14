package com.shopease.automation.utils;

import java.time.LocalDateTime;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static void initialize(String suiteName) throws IOException {

        if (extent == null) {

            String timestamp = LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")
            );

            String reportName = suiteName + "_" + timestamp + ".html";

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(
                            "test-output/" + reportName
                    );
            sparkReporter.loadJSONConfig(
                    new File("config/spark-config.json")
            );

            extent = new ExtentReports();

            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Project", "ShopEase");
            extent.setSystemInfo("Framework", "Selenium with TestNG");
            extent.setSystemInfo("Language", "Java 21");
            extent.setSystemInfo("Browser", "Chrome");
            extent.setSystemInfo("Suite", suiteName);
        }
    }

    public static ExtentReports getInstance() {
        return extent;
    }
}