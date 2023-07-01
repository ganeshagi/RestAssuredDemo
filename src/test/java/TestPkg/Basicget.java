package TestPkg;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class Basicget {
	@Test(priority = 1)
	public void test_verify_response_statuscode()
	{
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.statusCode()+"\n");
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	@Test(priority = 2)
	public void test_verify_get_response_header()
	{
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		Assert.assertEquals(response.header("Content-Type"),"application/json; charset=utf-8");
		Assert.assertEquals(response.header("Connection"), "keep-alive");
		Assert.assertEquals(response.header("Cache-Control"), "max-age=14400");
		Assert.assertEquals(response.header("Content-Encoding"), "gzip");
	}
	
	@Test(priority = 3)
	public void test_verify_get_response_body()
	{
		RestAssured.baseURI = "https://reqres.in";
		Response response = RestAssured.get("/api/users?page=2");
		
		ResponseBody body = response.getBody();
		String bodyasstring = body.asString();
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		System.out.println(jsonPathEvaluator.get("data"));
	}
}