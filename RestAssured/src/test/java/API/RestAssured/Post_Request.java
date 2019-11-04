package API.RestAssured;

import javax.xml.ws.Response;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.gson.JsonObject;
import com.sun.istack.logging.Logger;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Post_Request  extends Base_Class {

	
	
	@BeforeClass
	public void Post()
	{
		logger.info("*****Started testcase OF PUT*****");
		RequestSpecification req=startSuite();
	}
	@Test
public void post()

{
		RequestSpecification req=startSuite();
		final ExtentTest	tester=extent.createTest("POST Request 1","Create List");

		logger.info("########## START TO VERIFYING POST REQUEST 1  ###########");

		logger.info("*****Verifying POST REQUEST 1*****");
		
		tester.log(Status.INFO, "create list success");

	
	JsonObject requestParams=new JsonObject();

	requestParams.addProperty("title", "Api");
	
	

	req.body(requestParams.toString());
	io.restassured.response.Response response=req.when().post("/lists").then().log().all().extract().response();
	int statusCode2 = response.getStatusCode();
	logger.info("Status Code==>>>> " + statusCode2);
	Assert.assertEquals(statusCode2, 201);
	tester.log(Status.PASS, "Status Code : " + statusCode2);
    }
@Test
public void test2() {
	RequestSpecification req=startSuite();
	final ExtentTest	tester=extent.createTest("POST Request 2","Create List");

	logger.info("########## START TO VERIFYING POST REQUEST 2 ###########");

	logger.info("*****Verifying POST REQUEST 2*****");
	tester.log(Status.INFO, "create list success");



JsonObject requestParams=new JsonObject();

requestParams.addProperty("title", "RestAssured");



req.body(requestParams.toString());
io.restassured.response.Response response=req.when().post("/lists").then().log().all().extract().response();
int statusCode2 = response.getStatusCode();
logger.info("Status Code==>>>> " + statusCode2);
Assert.assertEquals(statusCode2, 201);
tester.log(Status.PASS, "Status Code : " + statusCode2);
}
}



