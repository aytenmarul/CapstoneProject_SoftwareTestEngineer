package stepDefinitions.backend_Api.login;

import enums.USER;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class login {


    String endPoint = "https://test.urbanicfarm.com/api/public/login";
    Map<String, String> map = new HashMap<>();
    Response response;
    JsonPath jsonPath;
    @Test
    public void name() {

        map.put("email", "aytenmarul23@gmail.com");
        map.put("password" ,"12345Numbers@");

        response = given()
                .contentType(ContentType.JSON)
                .body(map)
                .post(endPoint);
        response.prettyPrint();
        response.prettyPeek();
        jsonPath = response.jsonPath();
        System.out.println(jsonPath.getBoolean("success"));
        System.out.println(jsonPath.getString("email"));
      Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(map.get("email"),jsonPath.getString("email"));
       Assert.assertEquals("Ayten", jsonPath.getString("first_name"));
        Assert.assertEquals("Marul", jsonPath.getString("first_lastname"));

    }
}

