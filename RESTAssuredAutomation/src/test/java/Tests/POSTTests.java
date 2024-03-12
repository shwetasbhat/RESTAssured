package Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;

public class POSTTests {
	
	@BeforeMethod
	public void setUp() {
		
		baseURI = "https://reqres.in";	
		
	}
	
	@Test
	public void verifyStatusCodeOfPOSTRequest() {
		
		JSONObject request = new JSONObject();
		request.put("name","AB");
		request.put("job","Cricketer");
		
	
		given().
		body(request.toJSONString()).
		when().
		post("/api/users").
		then()
		.statusCode(201);
		   
		
	}
	
	@Test
	public void verifyStatusCodeOfUnsuccessfulLogin() {
		JSONObject request = new JSONObject();
		request.put("email", "ab@gmail.com");
		
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().post("api/login").
		then().
		statusCode(400);
		
		
	}
	
	@Test
	public void verifyStatusCodeOfSuccessfulLogin() {
		JSONObject request = new JSONObject();
		request.put("email","eve.holt@reqres.in");
		request.put("password","cityslicka");
		
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().post("api/login").
		then().
		statusCode(200);
		
	}

}
