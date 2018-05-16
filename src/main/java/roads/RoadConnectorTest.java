package roads;

import static com.jayway.restassured.RestAssured.given;
import org.junit.Test;




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
