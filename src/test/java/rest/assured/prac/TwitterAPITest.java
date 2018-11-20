package rest.assured.prac;

import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasXPath;
import java.util.ArrayList;
import static org.hamcrest.Matchers.*;
import java.util.concurrent.TimeUnit;
import io.restassured.response.Response;
import static rest.assured.prac.constants.Auth.*;
import static rest.assured.prac.constants.EndPoints.*;
import static rest.assured.prac.constants.Path.*;


/*
(base path, uri, secret keys) :- move to a file
test data :- all test dats in file
flow test :- define flow test in file
use pojo to create request object read object from file.
use pojo to create response object and use assert equals.
fuzzy logic, dynamic matching , regular expression.
log failed test request / response
common code for request and response
compare response header.
  .then()
  .statusCode(200)
  .header("content-type", "application/json;charset=utf-8")
random number, ramdom string, random alpha numeric string
 */

public class TwitterAPITest {

    String tweetId = "";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = STATUSES;
    }


    //we onboard to the service and create a test app and use the consumerKey, consumerSecret, accessToken, accessSecret to access service.

    /*
https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=rakesh kandpal

	BASE_URI = "https://api.twitter.com";
	basePath = "/1.1/statuses";

Authorization (header)-
OAuth oauth_consumer_key="32WwPfPSy0aYnDtKyad9CEsDx",oauth_token="925718178964967424-g3t64nqDstm075OqE7eV95zkLKG2SrK",oauth_signature_method="HMAC-SHA1",oauth_timestamp="1509547075",oauth_nonce="IeJoi44gdK8",oauth_version="1.0",oauth_signature="Yk%2BOjD%2FvoeXkHiOCAuVQB8Sz79M%3D"
 */


    /*
    	public static final String STATUSES_USER_TIMELINE = "/user_timeline.json";
	public static final String STATUSES_TWEET_POST = "/update.json";
	public static final String STATUSES_TWEET_READ_SINGLE = "/show.json";
	public static final String STATUSES_TWEET_DESTROY = "/destroy/{id}.json";
     */



    @Test
    public void twitterPost_extractJsonResponse() {
        Response response =
                given().log().all()
                        .auth()
                        .oauth(CONSUMER_KEY, CONSUMER_SECRET, ACCESS_TOKEN,
                                ACCESS_SECRET)
                        .queryParam("status", "My eight Tweet")
                        .when()
                        .post(STATUSES_TWEET_POST)
                        .then().log().all()
                        .statusCode(200)
                        .extract()
                        .response();

        tweetId = response.path("id_str");
        System.out.println("The response.path: " + tweetId);

        String responseString = response.asString();
        System.out.println(responseString);

        JsonPath jsPath = new JsonPath(responseString);
        String name = jsPath.get("user.name");
        System.out.println("The username is: " + name);
    }

    @Test(dependsOnMethods={"twitterPost_extractJsonResponse"})
    public void readTweet() {
        Response response =
                given().log().all()
                        .auth()
                        .oauth(CONSUMER_KEY, CONSUMER_SECRET, ACCESS_TOKEN,
                                ACCESS_SECRET)
                        .queryParam("id", tweetId)
                        .when()
                        .get(STATUSES_TWEET_READ_SINGLE)
                        .then()
                        .extract()
                        .response();

        String text = response.path("text");
        System.out.println("The tweet text is: " + text);
    }

    @Test(dependsOnMethods={"twitterPost_extractJsonResponse"})
    public void twitterGet() {
        Response res = given().log().all()
                .auth()
                .oauth(CONSUMER_KEY, CONSUMER_SECRET, ACCESS_TOKEN,
                        ACCESS_SECRET)
                .queryParam("screen_name", "rakesh kandpal")
                .when()
                .get(STATUSES_USER_TIMELINE);

        System.out.println(res.body().prettyPrint());

        res.then().statusCode(200);
    }

    @Test(dependsOnMethods={"twitterPost_extractJsonResponse"})
    public void deleteTweet() {
        given().log().all()
                .auth()
                .oauth(CONSUMER_KEY, CONSUMER_SECRET, ACCESS_TOKEN,
                        ACCESS_SECRET)
                .pathParam("id", tweetId)
                .when()
                .post(STATUSES_TWEET_DESTROY)
                .then()
                .statusCode(200);
    }

    //all soft assertion will run even if one of them fails.
    //soft assertion is achived by placing all validation under one body.
    @Test(dependsOnMethods={"twitterPost_extractJsonResponse"})
    public void softAssertionOfTweets() {
        given().log().all()
                .auth()
                .oauth(CONSUMER_KEY, CONSUMER_SECRET, ACCESS_TOKEN,
                        ACCESS_SECRET)
                .queryParam("screen_name", "rakesh kandpal")
                .when()
                .get(STATUSES_USER_TIMELINE)
                .then().log().all()
                .statusCode(200)
                .body("user.name", hasItem("rakesh kandpal"));
                //.body("entities.hashtags[0].text", hasItem("multiple1"), //list contains
                        //"entities.hashtags[0].size()", equalTo(3),  //list size
                        //"entities.hashtags[1].size()", lessThan(2));  //list size
    }


    //test will stop as soon as one expection fails. next assertions will not run.
    @Test
    public void hardAssertionOfTweets() {
        given()
                .auth()
                .oauth(CONSUMER_KEY, CONSUMER_SECRET, ACCESS_TOKEN,
                        ACCESS_SECRET)
                .queryParam("user_id", "925718178964967424")
                .when()
                .get(STATUSES_USER_TIMELINE)
                .then()
                .statusCode(200)
                .body("user.name", hasItem("rakesh kandpal")) ;
                //.body("entities.hashtags[0].text", hasItem("multiple1")) //list contains
                //.body("entities.hashtags[0].size()", equalTo(3)) //list size
                //.body("entities.hashtags[1].size()", lessThan(2)); //list size
    }


    @Test
    public void rootPathAssertionTest() {
        given()
                .auth()
                .oauth(CONSUMER_KEY, CONSUMER_SECRET, ACCESS_TOKEN,
                        ACCESS_SECRET)
                .queryParam("user_id", "925718178964967424")
                .when()
                .get(STATUSES_USER_TIMELINE)
                .then()
                .statusCode(200)
                .log().body()
                //declare root path
                .rootPath("user")
			    .body("name", hasItem("rakesh kandpal"))
			    .body("screen_name", hasItem("rakeshkandpal14"));
                //.rootPath("entities.hashtags[0]")
                //.body("text", hasItem("multiple"))
                //.body("size()", equalTo(2));
    }

    @Test
    public void timeOutAssertion() {
//		long responseTime =
//		given()
//			.auth()
//			.oauth(consumerKey, consumerSecret, accessToken, accessSecret)
//			.queryParam("user_id", "apiautomation")
//		.when()
//			.get("/user_timeline.json")
//			//.time();
//			.timeIn(TimeUnit.SECONDS);

//		System.out.println("Response Time: " + responseTime);

        given()
                .auth()
                .oauth(CONSUMER_KEY, CONSUMER_SECRET, ACCESS_TOKEN,
                        ACCESS_SECRET)
                .queryParam("user_id", "925718178964967424")
                .when()
                    .get(STATUSES_USER_TIMELINE)
                .then()
                    .statusCode(200)
                    .header("content-type", "application/json;charset=utf-8")
                    .time(lessThan(2L), TimeUnit.SECONDS)
                    .log().all()
                     .rootPath("user")
                    .body("name", hasItem("rakesh kandpal"))
                    .body("screen_name", hasItem("rakeshkandpal14"));
    }
}





/*
post response -
{
    "created_at": "Wed Nov 01 14:23:59 +0000 2017",
    "id": 925730140692258816,
    "id_str": "925730140692258816",
    "text": "My First Tweet",
    "truncated": false,
    "entities": {
        "hashtags": [

        ],
        "symbols": [

        ],
        "user_mentions": [

        ],
        "urls": [

        ]
    },
    "source": "<a href=\"https://www.test.com\" rel=\"nofollow\">haldwani</a>",
    "in_reply_to_status_id": null,
    "in_reply_to_status_id_str": null,
    "in_reply_to_user_id": null,
    "in_reply_to_user_id_str": null,
    "in_reply_to_screen_name": null,
    "user": {
        "id": 925718178964967424,
        "id_str": "925718178964967424",
        "name": "rakesh kandpal",
        "screen_name": "rakeshkandpal14",
        "location": "",
        "description": "",
        "url": null,
        "entities": {
            "description": {
                "urls": [

                ]
            }
        },
        "protected": false,
        "followers_count": 0,
        "friends_count": 0,
        "listed_count": 0,
        "created_at": "Wed Nov 01 13:36:27 +0000 2017",
        "favourites_count": 0,
        "utc_offset": null,
        "time_zone": null,
        "geo_enabled": false,
        "verified": false,
        "statuses_count": 0,
        "lang": "en",
        "contributors_enabled": false,
        "is_translator": false,
        "is_translation_enabled": false,
        "profile_background_color": "F5F8FA",
        "profile_background_image_url": null,
        "profile_background_image_url_https": null,
        "profile_background_tile": false,
        "profile_image_url": "http://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png",
        "profile_image_url_https": "https://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png",
        "profile_link_color": "1DA1F2",
        "profile_sidebar_border_color": "C0DEED",
        "profile_sidebar_fill_color": "DDEEF6",
        "profile_text_color": "333333",
        "profile_use_background_image": true,
        "has_extended_profile": false,
        "default_profile": true,
        "default_profile_image": true,
        "following": false,
        "follow_request_sent": false,
        "notifications": false,
        "translator_type": "none"
    },
    "geo": null,
    "coordinates": null,
    "place": null,
    "contributors": null,
    "is_quote_status": false,
    "retweet_count": 0,
    "favorite_count": 0,
    "favorited": false,
    "retweeted": false,
    "lang": "en"
}
{
    "created_at": "Wed Nov 01 14:23:59 +0000 2017",
    "id": 925730140692258816,
    "id_str": "925730140692258816",
    "text": "My First Tweet",
    "truncated": false,
    "entities": {
        "hashtags": [

        ],
        "symbols": [

        ],
        "user_mentions": [

        ],
        "urls": [

        ]
    },
    "source": "<a href=\"https://www.test.com\" rel=\"nofollow\">haldwani</a>",
    "in_reply_to_status_id": null,
    "in_reply_to_status_id_str": null,
    "in_reply_to_user_id": null,
    "in_reply_to_user_id_str": null,
    "in_reply_to_screen_name": null,
    "user": {
        "id": 925718178964967424,
        "id_str": "925718178964967424",
        "name": "rakesh kandpal",
        "screen_name": "rakeshkandpal14",
        "location": "",
        "description": "",
        "url": null,
        "entities": {
            "description": {
                "urls": [

                ]
            }
        },
        "protected": false,
        "followers_count": 0,
        "friends_count": 0,
        "listed_count": 0,
        "created_at": "Wed Nov 01 13:36:27 +0000 2017",
        "favourites_count": 0,
        "utc_offset": null,
        "time_zone": null,
        "geo_enabled": false,
        "verified": false,
        "statuses_count": 0,
        "lang": "en",
        "contributors_enabled": false,
        "is_translator": false,
        "is_translation_enabled": false,
        "profile_background_color": "F5F8FA",
        "profile_background_image_url": null,
        "profile_background_image_url_https": null,
        "profile_background_tile": false,
        "profile_image_url": "http://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png",
        "profile_image_url_https": "https://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png",
        "profile_link_color": "1DA1F2",
        "profile_sidebar_border_color": "C0DEED",
        "profile_sidebar_fill_color": "DDEEF6",
        "profile_text_color": "333333",
        "profile_use_background_image": true,
        "has_extended_profile": false,
        "default_profile": true,
        "default_profile_image": true,
        "following": false,
        "follow_request_sent": false,
        "notifications": false,
        "translator_type": "none"
    },
    "geo": null,
    "coordinates": null,
    "place": null,
    "contributors": null,
    "is_quote_status": false,
    "retweet_count": 0,
    "favorite_count": 0,
    "favorited": false,
    "retweeted": false,
    "lang": "en"
}

 */






