package tests;

import org.testng.annotations.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;


import org.hamcrest.core.IsEqual;


public class TestExamples {

	@Test
	public void testOne() {
		Response response  = get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode,200);
	}
	@Test
	public void testTwo() {
		baseURI = "https://reqres.in" ;
		given()
			.get("/api/users?page=2").
		then()
			.statusCode(200)
			.body("data[1].id",IsEqual.equalTo(8))
			.log().all();
	}
}
