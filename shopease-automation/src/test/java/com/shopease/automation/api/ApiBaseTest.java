package com.shopease.automation.api;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class ApiBaseTest {

    @BeforeClass
    public void setup() {

        RestAssured.baseURI = "http://localhost:8080";

        System.out.println("API Base URI: " + RestAssured.baseURI);
    }
}