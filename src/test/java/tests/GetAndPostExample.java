package tests;


import org.hamcrest.core.IsEqual;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class GetAndPostExample {

	@Test
	public void testGet() {
		baseURI = "https://reqres.in/api" ;
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[4].first_name",IsEqual.equalTo("George"));
		}
	
	@Test
	public void testPost() {
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject request = new JSONObject(map);
		request.put("name","john");
		request.put("job","Tester");
		baseURI = "https://reqres.in/api" ;
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).log().all();
	}
}
