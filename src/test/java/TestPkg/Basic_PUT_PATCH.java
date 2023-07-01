package TestPkg;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Basic_PUT_PATCH {
	@BeforeTest
	public void test_beforeTest()
	{
		baseURI="https://reqres.in/";
	}
	@Test
	public void test_PUT_PATCH_DELETE()
	{
		JSONObject req = new JSONObject();
		req.put("name","ganesh");
		req.put("job", "software_engineer");
		
		given().
			contentType(ContentType.JSON).
			body(req.toJSONString()).
		when().
			put("/api/users/2").
		then().
			statusCode(200);
	}

}
