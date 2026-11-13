package com.shopease.automation.utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

	//Hard Code
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {

        return new Object[][] {
            {"customer1@example.com", "TestPassword1", true},
            {"customer2@example.com", "TestPassword2", true},
            {"invalid@example.com", "InvalidPassword", false}
        };
    }
    
    //Excel data
    @DataProvider(name = "excelLoginData")
    public Object[][] getExcelLoginData() throws IOException {

        String filePath = "src/test/resources/testdata/LoginTestData.xlsx";

        return ExcelUtils.getExcelData(filePath, "LoginTestData");
        
    }
    
    //JSON File
    @DataProvider(name = "jsonLoginData")
    public Object[][] getJsonLoginData() throws IOException {

        String filePath =
                "src/test/resources/testdata/LoginTestData.json";

        return JsonUtils.getJsonData(filePath);
    }
}

