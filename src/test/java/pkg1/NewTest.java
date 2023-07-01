package pkg1;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void test_f1() {
	// Given
			given()
				.baseUri("https://reqres.in")
			// When
			.when()
				.get("/api/users?page=2")
			// Then
			.then()
				.statusCode(200)
				.statusLine("HTTP/1.1 200 OK");
				// To verify booking count
//				.body("bookingid", hasSize(1902))
//				// To verify booking id at index 3
//				.body("bookingid[3]", equalTo(1));			
  }
}
