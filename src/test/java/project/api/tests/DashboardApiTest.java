package project.api.tests;

import core.api.BaseTest;
import org.junit.Test;
import project.api.entities.Login;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DashboardApiTest extends BaseTest {
    @Test
    public void verifySummaryNotEmptyTest() {
        String token = Login.getToken();
        given().
                contentType("application/json").header("SessionToken", token).
                when().
                get("/Data/GetSummary").
                then().
                assertThat().statusCode(200).
                assertThat().body(containsString("Trainings")).
                body("Working", greaterThan(70));
    }
}
