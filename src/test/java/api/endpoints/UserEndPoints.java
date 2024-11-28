package api.endpoints;


import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.net.ResponseCache;

import api.payload.User;

//UserendPoints
//create to perform create,read,update,delete requests for the user api
public class UserEndPoints {

	public static Response createUser(User payload) {
		
		Response response=given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.body(payload)
		.when().post(Routes.post_user);
			
			return response;
	}
	
public static Response readUser(String userName) {
		
		Response response=given().pathParam("username", userName)
			
			
		.when().get(Routes.get_user);
			
			return response;
	}

public static Response updateUser(User payload,String userName) {
	
	Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.pathParam("username", userName)
		.body(payload)
	.when().put(Routes.put_user);
		
		return response;
}

public static Response deleteUser(String userName) {
	
	Response response=given()
		.pathParam("username", userName)
	.when().delete(Routes.delete_user);
		
		return response;
}
}
