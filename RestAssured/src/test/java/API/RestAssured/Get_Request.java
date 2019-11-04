package API.RestAssured;



import org.apache.http.HttpRequest;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.gson.JsonObject;
import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.Static;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

public class Get_Request extends Base_Class
{
	
	@BeforeClass
	 public void GetRequest()
	{

		logger.info("*****Started testcase OF List*****");
		RequestSpecification req=startSuite();

	}
	@Test
	public void Test1() {
		RequestSpecification req=startSuite();
		

	final ExtentTest	tester=extent.createTest("GET REQUEST 1","Create List");

		tester.log(Status.INFO, "create list success");
		
		logger.info("####### START TO VERIFYING GET REQUEST1  ######");

	
		



	
		logger.info("*****Verifying GET Request*****");

	
		Response response= req.when().get("/lists").then().log().all().extract().response();
		int statusCode = response.getStatusCode();
		logger.info("Status Code==>>>> " + statusCode);
		Assert.assertEquals(statusCode, 200);
		tester.log(Status.PASS, "Status Code : " + statusCode);

}
	@Test
	public void Test2()
	{
			RequestSpecification req=startSuite();
			final ExtentTest	tester=extent.createTest("GET REQUEST 2","Create List");

			tester.log(Status.INFO, "create list success");
			logger.info("####### START TO VERIFYING GET REQUEST2  ######");

			
			Response response= req.when().get("/lists/"+id).then().log().all().extract().response();

			int statusCode = response.getStatusCode();
			logger.info("Status Code==>>>> " + statusCode);
			Assert.assertEquals(statusCode, 200);
			tester.log(Status.PASS, "Status Code : " + statusCode);
	}
	
}
