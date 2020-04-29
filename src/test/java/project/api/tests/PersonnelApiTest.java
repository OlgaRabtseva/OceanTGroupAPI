package project.api.tests;

import core.api.BaseTest;
import org.junit.Test;
import project.api.entities.Login;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PersonnelApiTest extends BaseTest {

    @Test
    public void verifyListUsersNotEmptyTest() {
        String token = Login.getToken();
        given().
                contentType("application/json").header("SessionToken", token).
                when().
                get("/Data/ListUsers").
                then().
                assertThat().statusCode(200).
                assertThat().body(containsString("Id"));
    }
    @Test
    public void addNewUserTest() {
        String token = Login.getToken();
        given().
                contentType("application/json").header("SessionToken", token).
                when().
                post("/Data/AddUser/").
                then().
                assertThat().statusCode(204);
    }
}
