package api.test;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

 

public class UserTests {

	Faker faker;
	User userPayload;
	
	public Logger logger;
	
	@BeforeClass
	public void setUpdata() {
	
		faker=new Faker();
		userPayload=new User();
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
	
	//log
		logger=LogManager.getLogger(this.getClass()); 
	}
	
	@Test(priority = 1)
	public void testPostUser() 
	{
		logger.info("************Creating User***********");
		Response response=UserEndPoints.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("************User is created***********");
	}
	
	@Test(priority = 2)
	public void testGetUserByName() 
	{
		logger.info("************Reading User Info***********");
		Response response=UserEndPoints.readUser(this.userPayload.getUsername() );
		Assert.assertEquals(response.getStatusCode(), 200);
		response.then().log().all();
		logger.info("************User Info is displayed***********");
	}
	
	@Test(priority = 3)
	public void testUpdateUserByName() {
		
		//update data  using payload
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		logger.info("************Updating User***********");
		Response response=UserEndPoints.updateUser(userPayload, this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("************User Updated***********");
		//Checking data after update
		logger.info("************ Reading updated User***********");
		Response resposneAfterUpdate= UserEndPoints.readUser(this.userPayload.getUsername());
		resposneAfterUpdate.then().log().all();
		Assert.assertEquals(resposneAfterUpdate.getStatusCode(), 200);
		logger.info("************Updated User is displayed***********");
	}
	
	@Test(priority = 4)
	public void testDeleteUserByName() {
		logger.info("************Deleting User***********");
		Response response=UserEndPoints.deleteUser(this.userPayload.getUsername() );
		Assert.assertEquals(response.getStatusCode(), 200);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("************User deleted***********");
		//checking data after delete
		logger.info("************Reading deleted user***********");
		Response resposneAfterDelete= UserEndPoints.readUser(this.userPayload.getUsername());
		resposneAfterDelete.then().log().all();
		Assert.assertEquals(resposneAfterDelete.getStatusCode(), 404);
		logger.info("************Deleted User confirmed***********");
	}
}