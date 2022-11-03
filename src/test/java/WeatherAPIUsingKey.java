import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class WeatherAPIUsingKey
{
    @Test
    public void toVerifyUserIsAbleToGetCurrentWeather() {
        RestAssured.baseURI = "http://api.weatherapi.com/v1";
        given()
                .header("key", "4cfd08e24fcb49e2bda80312220211")
                .header("Accept", "application/json")
                .queryParam("q", "SW1")
                .get("/current.json")
                .then()
                .log().all();
    }
}
