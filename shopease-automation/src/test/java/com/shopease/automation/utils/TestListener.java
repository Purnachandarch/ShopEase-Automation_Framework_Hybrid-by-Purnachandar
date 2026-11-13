
package com.shopease.automation.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestListener implements ITestListener {

	private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Override
	public void onTestStart(ITestResult result) {

		ExtentReports extent = ExtentReportManager.getInstance();

		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());

		test.set(extentTest);

		test.get().info("Test execution started");

		System.out.println("TEST STARTED: " + result.getName());
	}

	private ExtentTest getOrCreateTest(ITestResult result) {

		ExtentTest extentTest = test.get();

		if (extentTest == null) {

			extentTest = ExtentReportManager.getInstance().createTest(result.getMethod().getMethodName());

			test.set(extentTest);
		}

		return extentTest;
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		getOrCreateTest(result).pass("Test passed successfully");

		System.out.println("TEST PASSED: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {

		getOrCreateTest(result).fail(result.getThrowable());

		System.out.println("TEST FAILED: " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		getOrCreateTest(result).skip(result.getThrowable());

		System.out.println("TEST SKIPPED: " + result.getName());
	}

	@Override
	public void onFinish(ITestContext context) {

		test.remove();
	}
}
