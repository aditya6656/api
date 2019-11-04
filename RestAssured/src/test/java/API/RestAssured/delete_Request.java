package API.RestAssured;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.ResponseBodyData;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class delete_Request extends Base_Class {


	@BeforeClass
	public void Delete()
	{
		logger.info("*****Started testcase OF DELETE*****");
		RequestSpecification req=startSuite();
	}
	@Test

public void DeleteRequest1(){
		tester=extent.createTest("DELETE Request 1","DELETE ID");

		logger.info("########## START TO VERIFYING DELETE REQUEST 1  ###########");

		logger.info("*****Verifying DELETE REQUEST 1*****");
		
		tester.log(Status.INFO, "DELETE ID success");
		RequestSpecification req=startSuite();

		io.restassured.response.Response getresponse=req.when().get("/lists").then().extract().response();
		int ID = getresponse.jsonPath().getInt("[10].id");
		

		


		
		JsonObject requestParams = new JsonObject();
		req.queryParam("revision", "1");
		

		req.body(requestParams.toString());
		io.restassured.response.Response response = req.when().delete("/lists/"+ ID);

		int statusCode = ((ResponseOptions<io.restassured.response.Response>) response).getStatusCode();
		System.out.println(((ResponseBodyData) response).asString());
		Assert.assertEquals(statusCode, 204); 
		int statusCode2 = response.getStatusCode();
		logger.info("Status Code==>>>> " + statusCode2);
		Assert.assertEquals(statusCode2, 204);
		tester.log(Status.PASS, "Status Code : " + statusCode2);

	}
	@Test
	public void DeleteRequest2()
	{
		tester=extent.createTest("DELETE Request 2","DELETE ID");

		logger.info("########## START TO VERIFYING DELETE REQUEST 2  ###########");

		logger.info("*****Verifying DELETE REQUEST 2*****");
		
		tester.log(Status.INFO, "DELETE ID success");

		RequestSpecification req=startSuite();

		io.restassured.response.Response getresponse=req.when().get("/lists").then().extract().response();
		int ID2 = getresponse.jsonPath().getInt("[7].id");
		


		
		JsonObject requestParams = new JsonObject();
		req.queryParam("revision", "1");
		

		req.body(requestParams.toString());
		io.restassured.response.Response response = req.when().delete("/lists/"+ ID2);

		int statusCode = ((ResponseOptions<io.restassured.response.Response>) response).getStatusCode();
		System.out.println(((ResponseBodyData) response).asString());
		Assert.assertEquals(statusCode, 204); 
		int statusCode2 = response.getStatusCode();
		logger.info("Status Code==>>>> " + statusCode2);
		Assert.assertEquals(statusCode2, 204);
		tester.log(Status.PASS, "Status Code : " + statusCode2);
		
	}
	
}






