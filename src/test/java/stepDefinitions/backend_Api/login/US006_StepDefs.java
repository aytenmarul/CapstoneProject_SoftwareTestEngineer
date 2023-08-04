package stepDefinitions.backend_Api.login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class US006_StepDefs  {
    String token;
   Response response;
    @Given("User sends get request using {string} for login")
    public void userSendsGetRequestUsingForLogin(String url) {
        String endpoint="https://test.urbanicfarm.com/api/public/login";
          //      "//auth/login";
        Map<String, String> info=new HashMap<>();
        info.put("email","aytenmarul23@gmail.com");
        info.put("password","12345Numbers@");
        response= RestAssured.given().contentType("application/json").when().body(info).get(endpoint);
       //response.prettyPeek();
        token = response.jsonPath().getString("token");
    }

    @And("user verifies the status code  {int}")
    public void userVerifiesTheStatusCode(int statusCode) {
        Assert.assertEquals(statusCode,response.getStatusCode());
        System.out.println("StatusCode="+response.getStatusCode());
        System.out.println("token="+ response.jsonPath().getString("token"));
    }


    @And("user verifies the content type is {string}")
    public void userVerifiesTheContentTypeIs(String contentType ) {
//String ContentType="text/html; charset=utf-8";

        Assert.assertEquals("application/json",response.contentType());
    }
}

