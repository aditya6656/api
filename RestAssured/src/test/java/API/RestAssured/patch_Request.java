package API.RestAssured;

import javax.xml.ws.Response;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.ResponseBodyData;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

public class patch_Request extends Base_Class {
	
	@BeforeClass
	public void patch()
	{

		logger.info("*****Started testcase OF PUT*****");
		RequestSpecification req=startSuite();
	}
	
	@Test
public void PatchRequest1(){
		RequestSpecification req=startSuite();
		tester=extent.createTest("PATCH REQUEST 1","Create List");

		tester.log(Status.INFO, "create list success");

		logger.info("####### START THE VERIFYING PATCH REQUEST  ######");

		
        

		logger.info("*****Verifying PATCH REQUEST 1*****");


		
		io.restassured.response.Response getresponse=req.when().get("/lists/"+id).then().log().all().extract().response();
		int getrevision = getresponse.jsonPath().getInt("revision");
		

		
		JsonObject requestParams = new JsonObject();
		requestParams.addProperty("revision", getrevision);
		requestParams.addProperty("title","Api"); 
		

		req.body(requestParams.toString());
		io.restassured.response.Response response = req.when().patch("/lists/"+ id);

		int statusCode = ((ResponseOptions<io.restassured.response.Response>) response).getStatusCode();
		System.out.println(((ResponseBodyData) response).asString());
		Assert.assertEquals(statusCode, 200); 
		int statusCode3 = response.getStatusCode();
		logger.info("Status Code==>>>> " + statusCode3);
		Assert.assertEquals(statusCode3, 200);
		tester.log(Status.PASS, "Status Code : " + statusCode3);

	}
	@Test
	
		public void PatchRequest2()
		{
		RequestSpecification req=startSuite();
		tester=extent.createTest("PATCH REQUEST 2","Create List");

		tester.log(Status.INFO, "create list success");

		logger.info("####### START THE VERIFYING PATCH REQUEST  ######");

		
        

		logger.info("*****Verifying PATCH REQUEST 1*****");


		
		io.restassured.response.Response getresponse=req.when().get("/lists/"+id).then().log().all().extract().response();
		int getrevision = getresponse.jsonPath().getInt("revision");
		

		
		JsonObject requestParams = new JsonObject();
		requestParams.addProperty("revision", getrevision);
		requestParams.addProperty("title","ApiTesting"); 
		

		req.body(requestParams.toString());
		io.restassured.response.Response response = req.when().patch("/lists/"+ id);

		int statusCode = ((ResponseOptions<io.restassured.response.Response>) response).getStatusCode();
		System.out.println(((ResponseBodyData) response).asString());
		Assert.assertEquals(statusCode, 200); 
		int statusCode3 = response.getStatusCode();
		logger.info("Status Code==>>>> " + statusCode3);
		Assert.assertEquals(statusCode3, 200);
		tester.log(Status.PASS, "Status Code : " + statusCode3);
		
	}
	
}



