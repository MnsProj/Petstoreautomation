package api.endpoints;


import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.net.ResponseCache;
import java.util.ResourceBundle;

import api.payload.User;

//UserendPoints
//create to perform create,read,update,delete requests for the user api
public class UserEndPoints2 {

	//method created for getting URL'S from properties file
	static ResourceBundle getURL() {
		ResourceBundle routes= ResourceBundle.getBundle("routes");//load properties file //name of the properties file
		return routes;
	}
	
	
	public static Response createUser(User payload) {
		
		
		String post_user=getURL().getString("post_user");//specifying here properties url then converting to string
		Response response=given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.body(payload)
		.when().post(post_user);
			
			return response;
	}
	
	public static Response readUser(String userName) {
		
		String get_user=getURL().getString("get_user");
		Response response=given().pathParam("username", userName)
			
			
		.when().get(get_user);
			
			return response;
	}

	public static Response updateUser(User payload,String userName) {
		String update_user=getURL().getString("update_user");
	Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.pathParam("username", userName)
		.body(payload)
	.when().put(update_user);
		
		return response;
}

	public static Response deleteUser(String userName) {
		String delete_user=getURL().getString("delete_user");
	Response response=given()
		.pathParam("username", userName)
	.when().delete(delete_user);
		
		return response;
}
}
