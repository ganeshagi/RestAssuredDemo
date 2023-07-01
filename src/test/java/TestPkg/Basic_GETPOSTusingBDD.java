package TestPkg;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import static org.hamcrest.core.IsEqual.*;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matcher;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;
public class Basic_GETPOSTusingBDD {
	@BeforeMethod
	public void test_beforemethod()
	{
		baseURI = "https://reqres.in";
	}
	
	@Test//(enabled=false)
	public void test_get_using_BDD()
	{
//		RestAssured.baseURI = "https://reqres.in";
		given().
			get("/api/users?page=2").
		then().
			statusCode(200).
			header("Content-Type","application/json; charset=utf-8").
			header("Connection", "keep-alive").
			header("Cache-Control", "max-age=14400").
			header("Cache-Control", "max-age=14400").
			
			body("page", equalTo(2)).
			body("per_page", equalTo(6)).
			body("total", equalTo(12)).
			body("total_pages", equalTo(2)).
			body("data[0].id", equalTo(7)).
			body("data[1].email", equalTo("lindsay.ferguson@reqres.in")).
			body("data[2].first_name", equalTo("Tobias")).
			body("data[3].last_name", equalTo("Fields")).
			body("data[4].avatar", equalTo("https://reqres.in/img/faces/11-image.jpg")).
			body("data.first_name", hasItems("Michael", "Lindsay")).
			log().all();			
	}
	
	@Test//(enabled=false)
	public void test_post_using_java_maps()
	{
		baseURI = "https://reqres.in";
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("name", "ganesh");
		map.put("job", "software_engineer");
		
		given().
			body(map).
		when().
			post("/api/users").
		then().
			statusCode(201);
	}
	
	@Test
	public void test_post_using_JSONObject()
	{
		JSONObject req = new JSONObject();
		
		req.put("name", "ashwini");
		req.put("job", "software_engineer");
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			body(req.toJSONString()).
		when().
			post("/api/users").
		then().
			statusCode(201);
	}

}
