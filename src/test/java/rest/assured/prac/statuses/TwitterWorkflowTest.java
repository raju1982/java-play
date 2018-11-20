package rest.assured.prac.statuses;

import static rest.assured.prac.constants.EndPoints.*;
import rest.assured.prac.constants.Path;
import rest.assured.prac.common.RestUtilities;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TwitterWorkflowTest {
	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	String tweetId = "";

	//@BeforeClass
	@BeforeTest
	public void setup() {
		reqSpec = RestUtilities.getRequestSpecification();
		reqSpec.basePath(Path.STATUSES);
		resSpec = RestUtilities.getResponseSpecification();
	}

	@Test
	public void postTweet() {
		Response response =
				given()
						.spec(reqSpec.queryParam("status", "My Fourth Tweet"))
				.when()
						.post(STATUSES_TWEET_POST) //"/update.json";
				.then()
						.spec(resSpec).log().all()
						.extract()
						.response();


		/*Response response =
				given()
					.spec(RestUtilities.createQueryParam(reqSpec, "status", "My Fourth Tweet"))
				.when()
					.post(STATUSES_TWEET_POST)
				.then()
					.spec(resSpec)
					.extract()
					.response();*/


		JsonPath jsPath = RestUtilities.getJsonPath(response);
		tweetId = jsPath.get("id_str");
		System.out.println("The response.path: " + tweetId);
	}
	
	@Test(dependsOnMethods={"postTweet"})
	public void readTweet() {
		RestUtilities.setEndPoint(STATUSES_TWEET_READ_SINGLE);
		Response res = RestUtilities.getResponse(
				RestUtilities.createQueryParam(reqSpec, "id", tweetId), "get");
		String text = res.path("text");
		System.out.println("The tweet text is: " + text);
	}

	@Test(dependsOnMethods={"readTweet"})
	public void deleteTweet() {
		given()
			.spec(RestUtilities.createPathParam(reqSpec, "id", tweetId))
		.when()
			.post(STATUSES_TWEET_DESTROY)
		.then()
			.spec(resSpec);
	}
}