package project.api.tests;


import core.api.BaseTest;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static project.api.entities.Credentials.getCreds;

public class LoginPositiveApiTest extends BaseTest {

    @Test
    public void successLoginTest() {
        given().
                contentType("application/json").
                body(getCreds()).
                when().
                post("/Session/Logon").
                then().
                assertThat().statusCode(200).
                body("$", hasKey("Token")).
                body("any { it.key == 'Token' }", is(notNullValue()));
    }
}
