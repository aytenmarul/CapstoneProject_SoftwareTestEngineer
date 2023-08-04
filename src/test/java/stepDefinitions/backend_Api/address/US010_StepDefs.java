package stepDefinitions.backend_Api.address;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ApiUtilities;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class US010_StepDefs {

    public static Response response;
    public static String token;
    public static Map<String, Object> payload = new HashMap<>();
    @When("User adds addresses {string},{string},{string},{string},{string},{string},{string},{string}")
    public void userAddsAddresses(String address, String city, String isDefault, String isSellerAddress, String postal, String state, String title, String emptyBasket) {
        ApiUtilities.Address.addAddress(address, city, Boolean.parseBoolean(isDefault),
                Boolean.parseBoolean(isSellerAddress), postal, state, title, Boolean.parseBoolean(emptyBasket), token);
      //  response.prettyPrint();
        response.jsonPath().getList(address);
    }
    @Then("user gets the status code {int}")
    public void userGetsTheStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, response.statusCode());
    }
    @Then("User verifies the response")
    public void user_verifies_the_response() {
        Assert.assertEquals(true,response.jsonPath().getBoolean("success"));

    }

    @Given("User sends post request using {string} for login")
    public void userSendsPostRequestUsingForLogin(String arg0) {
        String endpoint="https://test.urbanicfarm.com/api/public/login";
        //      "//auth/login";
        Map<String, String> info=new HashMap<>();
        info.put("email","aytenmarul23@gmail.com");
        info.put("password","12345Numbers@");
        response= RestAssured.given().contentType("application/json").when().body(info).get(endpoint);
        //response.prettyPeek();
        token = response.jsonPath().getString("token");
    }
}
