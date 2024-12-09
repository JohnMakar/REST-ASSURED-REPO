package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;



public class PutDeletePatchExamples {

	@Test
	public void testPut() {
		JSONObject request  = new JSONObject();
		request.put("name","john");
		request.put("job", "tester");
	
		baseURI = "https://reqres.in/api" ;
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users/2").
		then().
			statusCode(201).log().all();		
		}
	
	@Test
	public void testPATCH() {
		JSONObject request  = new JSONObject();
		request.put("name","john");
		request.put("job", "tester");
	
		baseURI = "https://reqres.in" ;
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/api/users/2").
		then().
			statusCode(200).log().all();	
		}
	@Test
	public void testDELETE() {
		baseURI = "https://reqres.in" ;
		given().
		when().
			delete("/api/users/2").
		then().
			statusCode(204).log().all();	
		}

}
