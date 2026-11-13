
package com.shopease.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.shopease.automation.base.BaseTest;

public class HomePageTest extends BaseTest {

    @Test
    public void verifyShopEaseHomePageLoads() {

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(
            currentUrl.contains("localhost:8080"),
            "ShopEase homepage did not load successfully"
        );

        System.out.println("ShopEase homepage loaded successfully!");
    }
}
