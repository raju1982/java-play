package rest.assured.prac;

import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasXPath;
import java.util.ArrayList;
import rest.assured.prac.google.distancematrix.DistancematrixResponse;
import io.restassured.response.Response;

public class RestAssuredDemo {

    /*
    question -
        read json from file.
        data provider.
        test api flow in json (one api calling another , create folder -> update folder)
        parallel test execution.
        test response header
        comparing request/response json/xml schema
        comparing entire json/xml response.
        comparing dynamic response using wildcard (json/xml)
        fuzzy logic
        mocking server.
        preparing dynamic json/xml request.
        how to integrate cucumber
        log request - response [ in a log file.  in a jenkins console.  in testng result file]
        setting request header.
        comparing response header.
        random number, string, alphanumeric string
        soft assertion , hard assertion
     */



	/***
     https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins=Washington,DC&destinations=New+York+City,NY&key=AIzaSyC01sErk6Ikc_oD3hy0d0lK1him9J-pJVs
     RestAssured.baseURI
     RestAssured.basePath
     .get("/distancematrix/json")
     .param("units", "imperial")
     .param("origins", "Washington,DC")
     .param("destinations", "New+York+City,NY")
     .param("key", "AIzaSyC01sErk6Ikc_oD3hy0d0lK1him9J-pJVs")
     */

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://maps.googleapis.com";
		RestAssured.basePath = "/maps/api";
	}

    @Test
    public void get_ResponsePojoMapping() {
        DistancematrixResponse res =
                given()
                        .queryParam("units", "imperial")
                        .queryParam("origins", "Washington,DC")
                        .queryParam("destinations", "New+York+City,NY")
                        .queryParam("key", "AIzaSyC01sErk6Ikc_oD3hy0d0lK1him9J-pJVs")
                        .when()
                        .get("/distancematrix/json")
                        .then().log().all()
                        .statusCode(200)
                        .extract().as(DistancematrixResponse.class);;

        System.out.println(res);

        /*
        import static org.assertj.core.api.Assertions.assertThat;
        assertThat(retrievedBlog.getName()).isEqualTo(newBlog.getName());
        assertThat(retrievedBlog.getDescription()).isEqualTo(newBlog.getDescription());
        assertThat(retrievedBlog.getUrl()).isEqualTo(newBlog.getUrl());
        assertThat(retrievedEntity).isEqualToIgnoringGivenFields(expectedEntity, "id");
        isEqualToIgnoringNullFields()
        */

        /*
        When it comes to making assertions about lists, there are three ways of doing this.

        A: Object mapping + AssertJ. Typesafe, readable, easy to debug, but more verbose.

    BlogListDTO retrievedBlogList = given()
        .spec(spec)
        .when()
        .get("blogs")
        .then()
        .statusCode(200)
        .extract().as(BlogListDTO.class);

    assertThat(retrievedBlogList.blogs)
        .extracting(blogEntry -> blogEntry.id)
        .contains(23);
         */


        /*
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class BlogListDTO {
    public int count;
    public List<BlogReference> blogs;
    public static class BlogReference{
        public int id;
        public String name;
        public String href;
    }
    }

    @TestPrac
    public void getBlogList(){
    BlogListDTO retrievedBlogs = given()
            .spec(spec)
            .when()
            .get("blogs")
            .then()
            .statusCode(200)
            .extract().as(BlogListDTO.class);
    assertThat(retrievedBlogs.count).isGreaterThan(7);
    assertThat(retrievedBlogs.blogs).isNotEmpty();
    }


Only add the necessary fields to the POJO. The service returns a JSON with 20 properties but you are only interested in two of them?
Add the @JsonIgnoreProperties(ignoreUnknown = true) annotation to your POJO class and Jackson won’t bother if there are more JSON properties
 in the response than fields in your POJO.
         */
    }
	
	@Test
	public void get_responseBody() {
		Response res =
		given()
			.queryParam("units", "imperial")
			.queryParam("origins", "Washington,DC")
			.queryParam("destinations", "New+York+City,NY")
			.queryParam("key", "AIzaSyC01sErk6Ikc_oD3hy0d0lK1him9J-pJVs")
		.when()
			.get("/distancematrix/json");
		//Message message = get("/message").as(Message.class);
		System.out.println(res.body().prettyPrint());
	}

	@Test
	public void get_validateJsonResponseBody() {
		given()
				.queryParam("units", "imperial")
				.queryParam("origins", "Washington,DC")
				.queryParam("destinations", "New+York+City,NY")
				.queryParam("key", "AIzaSyC01sErk6Ikc_oD3hy0d0lK1him9J-pJVs")
				.when()
				.get("/distancematrix/json")
				.then()
				.statusCode(200)
				.and()
				.body("rows[0].elements[0].distance.text", equalTo("225 mi"))
				.contentType(ContentType.JSON);
	}

    @Test
    public void get_validateXMLResponseBody() {
        Response res =
        given()
                .queryParam("units", "imperial")
                .queryParam("origins", "Washington,DC")
                .queryParam("destinations", "New+York+City,NY")
                .queryParam("key", "AIzaSyC01sErk6Ikc_oD3hy0d0lK1him9J-pJVs")
                .when()
                .get("/distancematrix/xml");

        System.out.println(res.body().prettyPrint());

        res.then()
                .statusCode(200)
                .and()
                .body(hasXPath("/DistanceMatrixResponse/row/element/distance/text[text()='225 mi']"))
                .contentType(ContentType.XML
                );
    }

    //.log().all() = request response log always.
    //
    @Test
    public void post_validateJsonResponseBody() {
        Response res = given()
                .queryParam("key", "AIzaSyAt1hdahEPCgTLcaV-SmHQQTwMqKmKQgPY")
                .body("{"
                        + "\"location\": {"
                        + "\"lat\": -33.8669710,"
                        + "\"lng\": 151.1958750"
                        + "},"
                        + "\"accuracy\": 50,"
                        + "\"name\": \"Google Shoes!\","
                        + "\"phone_number\": \"(02) 9374 4000\","
                        + "\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\","
                        + "\"types\": [\"shoe_store\"],"
                        + "\"website\": \"http://www.google.com.au/\","
                        + "\"language\": \"en-AU\""
                        + "}")
                .when()
                .post("/place/add/json");

        System.out.println(res.body().asString());

        res.then()
			.statusCode(200).and()
			.contentType(ContentType.JSON).and()
			.body("scope", equalTo("APP")).and()
			.body("status", equalTo("OK"));
    }

    // xml or json
    @Test
    public void post_javaObjectTOJsonRequest() {
        Location location = new Location();
        location.setLat(-33.8669710);
        location.setLng(151.1958750);

        ArrayList<String> types = new ArrayList<String>();
        types.add("shoe_store");

        PlaceAddRequest places = new PlaceAddRequest();
        places.setLocation(location);
        places.setAccuracy(50);
        places.setName("Google Shoes!");
        places.setPhone_number("(02) 9374 4000");
        places.setAddress("48 Pirrama Road, Pyrmont, NSW 2009, Australia");
        places.setTypes(types);
        places.setWebsite("http://www.google.com.au/");
        places.setLanguage("en-AU");

        // jackson or gson -> They serialize the object into JSON format
        Response res =
        given()
                .log().all()
                .queryParam("key", "AIzaSyAt1hdahEPCgTLcaV-SmHQQTwMqKmKQgPY")
                .contentType("application/json")  // xml or json
                .body(places)
                .when()
                .post("/place/add/json");   // xml or json

                System.out.println(res.body().asString());

                res.then()
                .statusCode(200).and()
                .contentType(ContentType.JSON) // xml or json
                 .and()
                .body("scope", equalTo("APP")).and()
                .body("status", equalTo("OK"));
    }

    // given().log().all()  log request
    // given().log().ifValidationFails() //if assertion fails  .body("PlaceAddResponse.status", equalTo("MK"));
    // given().log().ifValidationFails() //status code not matching is validation failure

    // then().log().all()  log response
    // then().log().ifValidationFails() //if assertion fails  .body("PlaceAddResponse.status", equalTo("MK"));
    // then().log().ifValidationFails() //status code not matching is validation failure

    //then().log().ifError()  [error while posting request , incorrect authrntication header, incorrect uri]

    @Test
    public void post_javaObjectTOXMLRequest() {
        Location location = new Location();
        location.setLat(-33.8669710);
        location.setLng(151.1958750);

        ArrayList<String> types = new ArrayList<String>();
        types.add("shoe_store");

        PlaceAddRequest places = new PlaceAddRequest();
        places.setLocation(location);
        places.setAccuracy(50);
        places.setName("Google Shoes!");
        places.setPhone_number("(02) 9374 4000");
        places.setAddress("48 Pirrama Road, Pyrmont, NSW 2009, Australia");
        places.setTypes(types);
        places.setWebsite("http://www.google.com.au/");
        places.setLanguage("en-AU");

        // jackson or gson -> They serialize the object into JSON format
        Response res =
                given()
                        .log().ifValidationFails()
                        .queryParam("key", "AIzaSyAt1hdahEPCgTLcaV-SmHQQTwMqKmKQgPY")
                        .contentType("application/xml")  // xml or json
                        .body(places)
                        .when()
                        .post("/place/add/xml");   // xml or json

        //System.out.println(res.body().asString());

        res.then().log().ifValidationFails()
                .statusCode(200).and()
                .contentType(ContentType.XML) // xml or json
                .and()
                .body("PlaceAddResponse.scope", equalTo("APP")).and()
                .body("PlaceAddResponse.status", equalTo("OK"));
    }
}

