package API.RestAssured;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.ResponseBodyData;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

public class Put_Request extends Base_Class {
	
	@BeforeClass
	 public void PutRequest()
	{

		logger.info("*****Started testcase OF PUT*****");
		RequestSpecification req=startSuite();

	}
	
	@Test
public void PutRequest1(){
		RequestSpecification req=startSuite();
		tester=extent.createTest("PUT REQUEST 1","Create List");

		tester.log(Status.INFO, "create list success");

		logger.info("####### START THE VERIFYING PUT REQUEST  ######");

		logger.info("*****Verifying PUT REQUEST 1*****");

		

		io.restassured.response.Response getresponse=req.when().get("/lists/"+id).then().log().all().extract().response();
		int getrevision = getresponse.jsonPath().getInt("revision");
		
		JsonObject requestParams = new JsonObject();
		requestParams.addProperty("revision", getrevision);
		requestParams.addProperty("title","Rest"); 
		

		req.body(requestParams.toString());
		io.restassured.response.Response response = req.when().put("/lists/"+ id);

		int statusCode = ((ResponseOptions<io.restassured.response.Response>) response).getStatusCode();
		System.out.println(((ResponseBodyData) response).asString());
		Assert.assertEquals(statusCode, 200); 
		int statusCode1 = response.getStatusCode();
		logger.info("Status Code==>>>> " + statusCode1);
		Assert.assertEquals(statusCode1, 200);
		tester.log(Status.PASS, "Status Code : " + statusCode1);

	}
	@Test
	public void PutRequest2()
	{
		RequestSpecification req=startSuite();
		tester=extent.createTest("PUT REQUEST 2 ","Create List");

		tester.log(Status.INFO, "create list success");

		logger.info("####### START THE VERIFYING PUT REQUEST  ######");

		logger.info("*****Verifying PUT REQUEST 2*****");

		

		io.restassured.response.Response getresponse=req.when().get("/lists/"+id).then().log().all().extract().response();
		int getrevision = getresponse.jsonPath().getInt("revision");
		
		JsonObject requestParams = new JsonObject();
		requestParams.addProperty("revision", getrevision);
		requestParams.addProperty("title","Assured"); 
		

		req.body(requestParams.toString());
		io.restassured.response.Response response = req.when().put("/lists/"+ id);

		int statusCode = ((ResponseOptions<io.restassured.response.Response>) response).getStatusCode();
		System.out.println(((ResponseBodyData) response).asString());
		Assert.assertEquals(statusCode, 200);
		int statusCode1 = response.getStatusCode();
		logger.info("Status Code==>>>> " + statusCode1);
		Assert.assertEquals(statusCode1, 200);
		tester.log(Status.PASS, "Status Code : " + statusCode1);
	}
	
}


