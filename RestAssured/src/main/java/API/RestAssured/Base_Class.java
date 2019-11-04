package API.RestAssured;

import org.apache.log4j.Logger;
import org.apache.log4j.Level;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.sun.tools.xjc.api.Property;
import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.Static;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base_Class {
	public static RequestSpecification httpRequest;
	public static Response response;
	public Logger logger;
	public int id=408981028;
	//public Static request;
	public static ExtentTest tester;
	public static ExtentHtmlReporter htmlReporter;
	public  static ExtentReports extent = new ExtentReports();

	public RequestSpecification startSuite()
	{
		RestAssured.baseURI ="https://a.wunderlist.com/api/v1";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");
		request.header("X-Access-Token","4de03b752017dd374c33e51248956278da6d63ce64581e5ec8926e7a9c47");
		request.header("X-Client-ID","a357e306ab14db6e0b4c");
		return request;
	}
	@BeforeClass 
	
	public void log4j()
	{
		logger=Logger.getLogger("RestApi");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
	}
	
	

	@BeforeSuite
	public void reportSetup() {
		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		tester = extent.createTest("TestCases","WunderListReport");
	}
	@AfterSuite
	public void reportTeardown() {
		extent.flush();
	}

}
