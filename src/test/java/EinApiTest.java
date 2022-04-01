import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class EinApiTest {

    @BeforeAll
    public static void setup() {
        // Setting BaseURI once
        RestAssured.baseURI = "http://80.158.6.63:30090";
        // Setting BasePath once
        RestAssured.basePath = "/api";
    }

    @Test
    void getAllCars() {
        given().get("/cars")
               .then()
               .statusCode(200);
    }

    @Test
    void getAllCarsMitKomplettemLog() {
        given().log()
               .all()
               .when()
               .get("/cars")
               .then()
               .log()
               .body()
               .statusCode(200);
    }

}
