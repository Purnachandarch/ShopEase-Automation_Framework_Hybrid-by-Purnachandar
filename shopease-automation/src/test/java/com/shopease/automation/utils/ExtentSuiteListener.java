package com.shopease.automation.utils;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.aventstack.extentreports.ExtentReports;

public class ExtentSuiteListener implements ISuiteListener  {

    @Override
    public void onStart(ISuite suite) {

        try {
			ExtentReportManager.initialize(suite.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        System.out.println(
            "EXTENT REPORT STARTED FOR SUITE: " + suite.getName()
        );
    }

    @Override
    public void onFinish(ISuite suite) {

        ExtentReports extent =
                ExtentReportManager.getInstance();

        if (extent != null) {
            extent.flush();
        }

        System.out.println(
            "EXTENT REPORT GENERATED FOR SUITE: " + suite.getName()
        );
    }
}