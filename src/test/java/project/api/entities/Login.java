package project.api.entities;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static project.api.entities.Credentials.getCreds;

public class Login {
    public static String getToken() {
        Response response = given().
                contentType("application/json").
                body(getCreds()).
                when().
                post("/Session/Logon").
                then().
                assertThat().statusCode(200).
                extract().response();
        return response.path("Token").toString();
    }
}
