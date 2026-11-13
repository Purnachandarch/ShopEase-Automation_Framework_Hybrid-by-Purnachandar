package com.shopease.automation.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductApiTest extends ApiBaseTest {

	@Test
	public void verifyGetAllProducts() {

		given().when().get("/api/products").then().statusCode(200).contentType("application/json").body("size()",
				greaterThan(0));

	}
	
	
	
	@Test
	public void verifyGetProductById() {

	    given()
	        .pathParam("id", 2)

	    .when()
	        .get("/api/products/{id}")

	    .then()
	        .statusCode(200)
	        .body("id", equalTo(2))
	        .body("name", notNullValue())
	        .body("price", greaterThan(0f));

	}
	
	
	@Test
	public void verifyProductResponseHeaders() {

	    given()

	    .when()
	        .get("/api/products")

	    .then()
	        .statusCode(200)
	        .header("Content-Type", containsString("application/json"));

	}
	
	@Test
	public void verifyProductResponseTime() {

	    given()

	    .when()
	        .get("/api/products")

	    .then()
	        .statusCode(200)
	        .time(lessThan(3000L));

	}
	
	//@Test
	public void verifyAddProduct() {

	    given()
	        .contentType("application/json")
	        .body("{"
	            + "\"name\":\"API Test Product\","
	            + "\"description\":\"Product created using REST Assured\","
	            + "\"price\":999.00,"
	            + "\"stock\":10,"
	            + "\"category\":\"Electronics\""
	            + "}")

	    .when()
	        .post("/api/products")

	    .then()
	        .statusCode(201)
	        .body("id", notNullValue())
	        .body("name", equalTo("API Test Product"));

	}
}