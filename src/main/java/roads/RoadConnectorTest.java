package roads;

import static com.jayway.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;


public class RoadConnectorTest extends FunctionalTest {

		 
	@Test
	public void givenUrl_whenSuccessOnGetsstatuscode200_thenCorrect() {
		   given().when().get("http://localhost:8080/connected").then().statusCode(200);
		
	}
	
	@Test
    public void verifyRouteexists() {

		 given().when().get("/connected?origin=Boston&destination=Philadelphia").then();
		 
       
    }
	
}
