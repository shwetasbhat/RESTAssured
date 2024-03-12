package Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;



public class GETTests {
	
	
	@BeforeMethod
	public void setUp() {
		
		baseURI = "https://reqres.in" ;	
		
		
	}
	
	 
	@Test
	public void verifyStatusCodeAndIdForListOfUsers() {
		
	
		
		given().
		get("/api/users?page=2").
		then().
		statusCode(200).
		body("data.id",hasItems(7,8,9,10,11,12));
	
		
	}
	
	@Test
	public void verifySizeOfReturnedUsersList() {
		
	
			given().
			get("/api/users?page=2").
			then().
			body("data.size()",is(6) );
				
		
	}
	
	
	
}

