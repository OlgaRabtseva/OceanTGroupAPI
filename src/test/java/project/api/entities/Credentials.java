package project.api.entities;

import java.util.HashMap;
import java.util.Map;

public class Credentials {

    public static Map<String,String> getCreds() {
    Map<String, String> creds = new HashMap<>();
        creds.put("Company", "DemoCompany");
        creds.put("User", "Admin");
        creds.put("Password", "Demo2020");
        return creds;
    }
}
