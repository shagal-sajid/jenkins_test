import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.github.cdimascio.dotenv.Dotenv;

public class Basic {
	
	public static void main(String args[]) {
		Dotenv dotenv = Dotenv.load();
		System.out.println(dotenv.get("KEY"));
		System.out.println(dotenv.get("WORD"));
		// Given - All Input details
		// When - Submit the API
		// Then - Validate The response
		
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		given().log().all()
		.when().get("posts/1")
		.then().log().all().assertThat().statusCode(200).body("id", equalTo(1)).header("Content-Encoding", equalTo("gzip"));
	}

}
