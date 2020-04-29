package project.api.tests;


import core.api.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

@RunWith(Parameterized.class)
public class LoginNegativeApiTest extends BaseTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "", "", ""},
                { "DemoCompany", "", ""},
                { "DemoCompany", "Admin", ""},
                { "DemoCompany", "", "Demo2020"},
                { "", "Admin", "Demo2020"},
                { "", "", "Demo2020"},
                { "", "", "Demo"},
                { "DemoCompany", "user", "Demo2020"},
        });
    }

    private final String company;
    private final String user;
    private final String password;

    public LoginNegativeApiTest(String company, String user, String password) {
        this.company = company;
        this.user = user;
        this.password = password;
    }

    public String getCompany() {
        return company;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    @Test
    public void failLoginTest() {
        Map<String, String> creds = new HashMap<>();
        creds.put("Company", getCompany());
        creds.put("User", getUser());
        creds.put("Password", getPassword());
        given().
                contentType("application/json").
                body(creds).
                when().
                post("/Session/Logon").
                then().
                assertThat().statusCode(400);
    }

}
