package rest.assured.prac.statuses;

import static rest.assured.prac.constants.EndPoints.*;

import org.testng.annotations.BeforeTest;
import rest.assured.prac.constants.Path;
import rest.assured.prac.common.RestUtilities;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;


public class UserTimelineTest {

	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	
	//@BeforeClass
	@BeforeTest
	public void setup() {
		reqSpec = RestUtilities.getRequestSpecification();
		reqSpec.queryParam("user_id", "925718178964967424");
		reqSpec.basePath(Path.STATUSES);
		resSpec = RestUtilities.getResponseSpecification();
	}

	@Test
	public void readTweets1() {
		given().log().all()
			.spec(RestUtilities.createQueryParam(reqSpec, "count", "1"))
		.when()
			.get(STATUSES_USER_TIMELINE)
		.then()
			.log().all()
			.spec(resSpec)
			.body("user.screen_name", hasItem("rakeshkandpal14"));
	}
	
	@Test
	public void readTweets2() {
		RestUtilities.setEndPoint(STATUSES_USER_TIMELINE);
		Response res = RestUtilities.getResponse(
				RestUtilities.createQueryParam(reqSpec, "count", "2"), "get");
		ArrayList<String> screenNameList = res.path("user.screen_name");
		System.out.println("Read Tweets 2 Method");
		System.out.println(screenNameList);
		Assert.assertTrue(screenNameList.contains("rakeshkandpal14"));
	}
}